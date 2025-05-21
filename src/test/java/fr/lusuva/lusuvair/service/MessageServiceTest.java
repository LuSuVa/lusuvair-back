package fr.lusuva.lusuvair.service;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import fr.lusuva.lusuvair.dtos.message.MessagePostDto;
import fr.lusuva.lusuvair.dtos.message.MessagePutDto;
import fr.lusuva.lusuvair.entities.Message;
import fr.lusuva.lusuvair.entities.Section;
import fr.lusuva.lusuvair.entities.UserAccount;
import fr.lusuva.lusuvair.repositories.MessageRepository;
import fr.lusuva.lusuvair.repositories.SectionRepository;
import fr.lusuva.lusuvair.services.MessageService;
import fr.lusuva.lusuvair.utils.ControllerUtils;

class MessageServiceTest {

    @InjectMocks
    private MessageService messageService;

    @Mock
    private MessageRepository messageRepository;

    @Mock
    private SectionRepository sectionRepository;

    @Mock
    private ControllerUtils controllerUtils;

    @Mock
    private UserDetails userDetails;

    private UserAccount user;
    private Message message;
    private Section section;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);

        user = new UserAccount();
        user.setId(1);
        user.setFirstName("user");

        section = new Section();
        section.setId(1);

        message = new Message();
        message.setId(1);
        message.setContent("Test content");
        message.setUser(user);
        message.setSection(section);
        message.setDate(LocalDateTime.now());
    }

    @Test
    void testCreate_Valid() {
        MessagePostDto dto = new MessagePostDto();
        dto.setContent("New message");
        dto.setSectionId(1);
        dto.setParentMessageId(-1);

        when(sectionRepository.findById(1)).thenReturn(Optional.of(section));
        when(messageRepository.findById(-1)).thenReturn(Optional.empty());
        when(messageRepository.save(any(Message.class))).thenAnswer(i -> i.getArgument(0));

        Message result = messageService.create(dto, user);

        assertEquals(dto.getContent(), result.getContent());
        assertEquals(user, result.getUser());
        assertEquals(section, result.getSection());
    }

    @Test
    void testCreate_InvalidSection() {
        MessagePostDto dto = new MessagePostDto();
        dto.setSectionId(99);

        when(sectionRepository.findById(99)).thenReturn(Optional.empty());

        assertThrows(NoSuchElementException.class, () -> messageService.create(dto, user));
    }

    @Test
    void testGetById_Found() {
        when(messageRepository.findById(1)).thenReturn(Optional.of(message));
        Message result = messageService.getById(1);
        assertEquals(message, result);
    }

    @Test
    void testGetById_NotFound() {
        when(messageRepository.findById(2)).thenReturn(Optional.empty());
        assertThrows(NoSuchElementException.class, () -> messageService.getById(2));
    }

    @Test
    void testGetAll() {
        List<Message> list = List.of(message);
        when(messageRepository.findAll()).thenReturn(list);
        assertEquals(list, messageService.getAll());
    }

    @Test
    void testUpdateById_Success() {
        MessagePutDto dto = new MessagePutDto();
        dto.setContent("Updated");

        when(messageRepository.findById(1)).thenReturn(Optional.of(message));
        when(controllerUtils.getUserAccount(userDetails)).thenReturn(user);

        messageService.updateById(1, dto, userDetails);

        assertEquals("Updated", message.getContent());
        verify(messageRepository).save(message);
    }

    @Test
    void testUpdateById_Unauthorized() {
        MessagePutDto dto = new MessagePutDto();
        dto.setContent("Updated");

        UserAccount otherUser = new UserAccount();
        otherUser.setId(2);

        when(messageRepository.findById(1)).thenReturn(Optional.of(message));
        when(controllerUtils.getUserAccount(userDetails)).thenReturn(otherUser);

        assertThrows(AuthenticationServiceException.class, () -> messageService.updateById(1, dto, userDetails));
    }

    @Test
    void testDeleteById_Success() {
        when(messageRepository.findById(1)).thenReturn(Optional.of(message));
        when(controllerUtils.getUserAccount(userDetails)).thenReturn(user);

        messageService.deleteById(1, userDetails);
        verify(messageRepository).delete(message);
    }

    @Test
    void testLikeMessage_Toggle() {
        when(messageRepository.findById(1)).thenReturn(Optional.of(message));
        when(controllerUtils.getUserAccount(userDetails)).thenReturn(user);

        messageService.like(1, userDetails);  // First like
        assertTrue(message.getUsersLiked().contains(user));

        messageService.like(1, userDetails);  // Then unlike
        assertFalse(message.getUsersLiked().contains(user));
    }

    @Test
    void testDislikeMessage_Toggle() {
        when(messageRepository.findById(1)).thenReturn(Optional.of(message));
        when(controllerUtils.getUserAccount(userDetails)).thenReturn(user);

        messageService.dislike(1, userDetails);  // First dislike
        assertTrue(message.getUsersDisliked().contains(user));

        messageService.dislike(1, userDetails);  // Then remove dislike
        assertFalse(message.getUsersDisliked().contains(user));
    }

    @Test
    void testAdminAuthorizationByRole() {
        UserAccount admin = new UserAccount();
        admin.setId(2);
        admin.setFirstName("admin");
        admin.setAuthorities(List.of(new SimpleGrantedAuthority("ADMIN")));

        when(controllerUtils.getUserAccount(userDetails)).thenReturn(admin);
        when(messageRepository.findById(1)).thenReturn(Optional.of(message));

        // Should pass due to admin privileges
        assertDoesNotThrow(() -> messageService.deleteById(1, userDetails));
    }
}