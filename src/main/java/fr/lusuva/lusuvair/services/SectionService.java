package fr.lusuva.lusuvair.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import fr.lusuva.lusuvair.dtos.section.SectionPostDto;
import fr.lusuva.lusuvair.dtos.section.SectionPutDto;
import fr.lusuva.lusuvair.entities.Forum;
import fr.lusuva.lusuvair.entities.Section;
import fr.lusuva.lusuvair.entities.UserAccount;
import fr.lusuva.lusuvair.repositories.SectionRepository;
import fr.lusuva.lusuvair.utils.ControllerUtils;

/**
 * Section Service
 */
@Service
public class SectionService {

    /**
     * Autowired Section Repository
     */
    @Autowired
    private SectionRepository sectionRepository;

    /**
     * Autowired Forum Service
     */
    @Autowired
    private ForumService forumService;

    /**
     * Autowired ControllerUtils
     */
    @Autowired
    private ControllerUtils controllerUtils;

    /**
     * Create a section and returns it
     * 
     * @param sectionPostDto Dto
     * @param userAccount    Authenticated user
     * @return Section newly saved
     */
    public Section create(SectionPostDto sectionPostDto, UserAccount userAccount) {
        Forum forum = forumService.getById(sectionPostDto.getForumId());

        Section section = new Section();

        section.setName(sectionPostDto.getTitle());
        section.setDescription(sectionPostDto.getContent());
        section.setDate(LocalDateTime.now());
        section.setUser(userAccount);
        section.setForum(forum);

        sectionRepository.save(section);

        return section;
    }

    /**
     * Get by id
     * 
     * @param id int
     * @return Section
     * @throws NoSuchElementException if Section is not find
     */
    public Section getById(int id) throws NoSuchElementException {
        Section section = sectionRepository.findById(id).orElse(null);

        if (section == null) {
            throw new NoSuchElementException("Section doesn't exist");
        }

        return section;
    }

    /**
     * Get all
     * 
     * @return List of Section
     */
    public List<Section> getAll() {
        return sectionRepository.findAll();
    }

    /**
     * Update by id
     * 
     * @param id            int
     * @param sectionPutDto dto
     * @return Section updated
     */
    public Section updateById(int id, SectionPutDto sectionPutDto, UserDetails userDetails) {
        Section section = getById(id);
        isOwnerUserOrAdmin(section, userDetails);

        section.setName(sectionPutDto.getTitle());
        section.setDescription(sectionPutDto.getContent());

        sectionRepository.save(section);

        return section;
    }

    /**
     * Delete by id
     * 
     * @param id int
     */
    public void deleteById(int id, UserDetails userDetails) {
        Section section = getById(id);
        isOwnerUserOrAdmin(section, userDetails);

        sectionRepository.delete(section);
    }

    /**
     * Check if the user owns the section or if he's admin
     * 
     * @param id          int
     * @param userDetails UserDetails
     * @throws AuthenticationServiceException if user isn't onwer or isn't admin
     */
    private void isOwnerUserOrAdmin(Section section, UserDetails userDetails) throws AuthenticationServiceException {
        UserAccount userAccount = controllerUtils.getUserAccount(userDetails);

        if (!section.getUser().equals(userAccount)
                && !userAccount.getAuthorities().contains(new SimpleGrantedAuthority("ADMIN"))) {
            throw new AuthenticationServiceException("Not Authorized");
        }
    }
}
