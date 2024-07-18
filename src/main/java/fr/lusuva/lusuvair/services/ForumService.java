package fr.lusuva.lusuvair.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.lusuva.lusuvair.dtos.forum.ForumPostDto;
import fr.lusuva.lusuvair.entities.Forum;
import fr.lusuva.lusuvair.repositories.ForumRepository;

/**
 * Forum Service
 */
@Service
public class ForumService {

    /**
     * Forum Repository
     */
    @Autowired
    private ForumRepository forumRepository;

    /**
     * Create a forum and return it
     * 
     * @param forumPostDto Dto
     * @return Forum
     */
    public Forum create(ForumPostDto forumPostDto) {
        Forum forum = new Forum();

        forum.setName(forumPostDto.getName());
        forumRepository.save(forum);

        return forum;
    }

    /**
     * Get forum by id
     * 
     * @param id int
     * @return Forum
     * @throws NoSuchElementException if no forum find
     */
    public Forum getById(int id) throws NoSuchElementException {
        Forum forum = forumRepository.findById(id).orElse(null);

        if (forum == null) {
            throw new NoSuchElementException("Could not find forum");
        }

        return forum;
    }

    /**
     * Get all
     * 
     * @return List of Forum
     */
    public List<Forum> getAll() {
        return forumRepository.findAll();
    }

    /**
     * Update a forum by id
     * 
     * @param id           int
     * @param forumPostDto dto
     * @return Forum updated
     */
    public Forum updateById(int id, ForumPostDto forumPostDto) {
        Forum forum = getById(id);

        forum.setName(forumPostDto.getName());

        forumRepository.save(forum);

        return forum;
    }

    /**
     * Delete by id
     * 
     * @param id int
     */
    public void deleteById(int id) {
        forumRepository.delete(getById(id));
    }
}
