package fr.lusuva.lusuvair.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import fr.lusuva.lusuvair.dtos.forum.ForumPostDto;
import fr.lusuva.lusuvair.entities.Forum;
import fr.lusuva.lusuvair.repositories.ForumRepository;
import fr.lusuva.lusuvair.services.ForumService;

public class ForumServiceTest {

	@Mock
	private ForumRepository forumRepository;
	
    @InjectMocks
    private ForumService forumService;

	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
	}
	
	  @Test
	    public void testCreate() {
	        ForumPostDto dto = new ForumPostDto();
	        dto.setName("Test Forum");

	        Forum forum = new Forum();
	        forum.setName("Test Forum");

	        when(forumRepository.save(any(Forum.class))).thenReturn(forum);

	        Forum createdForum = forumService.create(dto);

	        assertNotNull(createdForum);
	        assertEquals("Test Forum", createdForum.getName());
	        verify(forumRepository, times(1)).save(any(Forum.class));
	    }
	
	    @Test
	    public void testGetById_Found() {
	        Forum forum = new Forum();
	        forum.setId(1);
	        forum.setName("Test Forum");

	        when(forumRepository.findById(1)).thenReturn(Optional.of(forum));

	        Forum foundForum = forumService.getById(1);

	        assertNotNull(foundForum);
	        assertEquals(1, foundForum.getId());
	        assertEquals("Test Forum", foundForum.getName());
	        verify(forumRepository, times(1)).findById(1);
	    }
	    
	    @Test
	    public void testGetById_NotFound() {
	        when(forumRepository.findById(1)).thenReturn(Optional.empty());

	        assertThrows(NoSuchElementException.class, () -> {
	            forumService.getById(1);
	        });

	        verify(forumRepository, times(1)).findById(1);
	    }
	    
	    @Test
	    public void testGetAll() {
	        Forum forum1 = new Forum();
	        forum1.setId(1);
	        forum1.setName("Test Forum 1");

	        Forum forum2 = new Forum();
	        forum2.setId(2);
	        forum2.setName("Test Forum 2");

	        List<Forum> forums = Arrays.asList(forum1, forum2);

	        when(forumRepository.findAll()).thenReturn(forums);

	        List<Forum> foundForums = forumService.getAll();

	        assertNotNull(foundForums);
	        assertEquals(2, foundForums.size());
	        verify(forumRepository, times(1)).findAll();
	    }
	    
	    @Test
	    public void testUpdateById() {
	        ForumPostDto dto = new ForumPostDto();
	        dto.setName("Updated Forum");

	        Forum forum = new Forum();
	        forum.setId(1);
	        forum.setName("Old Forum");

	        when(forumRepository.findById(1)).thenReturn(Optional.of(forum));
	        when(forumRepository.save(any(Forum.class))).thenReturn(forum);

	        Forum updatedForum = forumService.updateById(1, dto);

	        assertNotNull(updatedForum);
	        assertEquals("Updated Forum", updatedForum.getName());
	        verify(forumRepository, times(1)).findById(1);
	        verify(forumRepository, times(1)).save(forum);
	    }

	    @Test
	    public void testDeleteById() {
	        Forum forum = new Forum();
	        forum.setId(1);
	        forum.setName("Test Forum");

	        when(forumRepository.findById(1)).thenReturn(Optional.of(forum));
	        doNothing().when(forumRepository).delete(any(Forum.class));

	        forumService.deleteById(1);

	        verify(forumRepository, times(1)).findById(1);
	        verify(forumRepository, times(1)).delete(forum);
	    }
}
