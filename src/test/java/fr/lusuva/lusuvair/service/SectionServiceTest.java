package fr.lusuva.lusuvair.service;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;
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

import fr.lusuva.lusuvair.dtos.section.SectionPostDto;
import fr.lusuva.lusuvair.dtos.section.SectionPutDto;
import fr.lusuva.lusuvair.entities.Section;
import fr.lusuva.lusuvair.entities.UserAccount;
import fr.lusuva.lusuvair.repositories.SectionRepository;
import fr.lusuva.lusuvair.services.SectionService;
import fr.lusuva.lusuvair.utils.ControllerUtils;

class SectionServiceTest {

    @InjectMocks
    private SectionService sectionService;

    @Mock
    private SectionRepository sectionRepository;

    @Mock
    private ControllerUtils controllerUtils;

    @Mock
    private UserDetails userDetails;

    private UserAccount user;
    private Section section;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);

        user = new UserAccount();
        user.setId(1);
        user.setFirstName("user");

        section = new Section();
        section.setId(1);
        section.setName("Title");
        section.setDescription("Content");
        section.setDate(LocalDateTime.now());
        section.setUser(user);
    }

    @Test
    void testCreateSection() {
        SectionPostDto dto = new SectionPostDto();
        dto.setTitle("Test Section");
        dto.setContent("Test Content");

        when(sectionRepository.save(any(Section.class))).thenAnswer(i -> i.getArgument(0));

        Section created = sectionService.create(dto, user);

        assertEquals("Test Section", created.getName());
        assertEquals("Test Content", created.getDescription());
        assertEquals(user, created.getUser());
        verify(sectionRepository).save(created);
    }

    @Test
    void testGetById_Found() {
        when(sectionRepository.findById(1)).thenReturn(Optional.of(section));

        Section result = sectionService.getById(1);
        assertEquals(section, result);
    }

    @Test
    void testGetById_NotFound() {
        when(sectionRepository.findById(1)).thenReturn(Optional.empty());

        assertThrows(NoSuchElementException.class, () -> sectionService.getById(1));
    }

    @Test
    void testGetAllSections() {
        List<Section> list = List.of(section);
        when(sectionRepository.findAll()).thenReturn(list);

        List<Section> result = sectionService.getAll();
        assertEquals(list, result);
    }

    @Test
    void testUpdateById_Authorized() {
        SectionPutDto dto = new SectionPutDto();
        dto.setTitle("Updated Title");
        dto.setContent("Updated Content");

        when(sectionRepository.findById(1)).thenReturn(Optional.of(section));
        when(controllerUtils.getUserAccount(userDetails)).thenReturn(user);

        Section updated = sectionService.updateById(1, dto, userDetails);

        assertEquals("Updated Title", updated.getName());
        assertEquals("Updated Content", updated.getDescription());
        verify(sectionRepository).save(updated);
    }

    @Test
    void testUpdateById_Unauthorized() {
        UserAccount otherUser = new UserAccount();
        otherUser.setId(2);
        otherUser.setAuthorities(new ArrayList<>()); 

        SectionPutDto dto = new SectionPutDto();
        dto.setTitle("Attempt");
        dto.setContent("Forbidden");

        when(sectionRepository.findById(1)).thenReturn(Optional.of(section));
        when(controllerUtils.getUserAccount(userDetails)).thenReturn(otherUser);

        assertThrows(AuthenticationServiceException.class, () -> sectionService.updateById(1, dto, userDetails));
    }

    @Test
    void testDeleteById_Authorized() {
        when(sectionRepository.findById(1)).thenReturn(Optional.of(section));
        when(controllerUtils.getUserAccount(userDetails)).thenReturn(user);

        sectionService.deleteById(1, userDetails);
        verify(sectionRepository).delete(section);
    }

    @Test
    void testDeleteById_AsAdmin() {
        UserAccount admin = new UserAccount();
        admin.setId(999);
        admin.setAuthorities(List.of(new SimpleGrantedAuthority("ADMIN")));

        when(sectionRepository.findById(1)).thenReturn(Optional.of(section));
        when(controllerUtils.getUserAccount(userDetails)).thenReturn(admin);

        assertDoesNotThrow(() -> sectionService.deleteById(1, userDetails));
    }

    @Test
    void testDeleteById_Unauthorized() {
        UserAccount otherUser = new UserAccount();
        otherUser.setId(3);
        otherUser.setAuthorities(new ArrayList<>()); 

        when(sectionRepository.findById(1)).thenReturn(Optional.of(section));
        when(controllerUtils.getUserAccount(userDetails)).thenReturn(otherUser);

        assertThrows(AuthenticationServiceException.class, () -> sectionService.deleteById(1, userDetails));
    }
}