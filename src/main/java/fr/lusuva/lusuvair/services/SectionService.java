package fr.lusuva.lusuvair.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.lusuva.lusuvair.dtos.section.SectionPostDto;
import fr.lusuva.lusuvair.entities.Section;
import fr.lusuva.lusuvair.entities.UserAccount;
import fr.lusuva.lusuvair.repositories.SectionRepository;

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
     * Create a section and returns it
     * 
     * @param sectionPostDto Dto
     * @param userAccount    Authenticated user
     * @return Section newly saved
     */
    public Section create(SectionPostDto sectionPostDto, UserAccount userAccount) {
        Section section = new Section();

        section.setName(sectionPostDto.getTitle());
        section.setDescription(sectionPostDto.getContent());
        section.setDate(LocalDateTime.now());
        section.setUser(userAccount);

        sectionRepository.save(section);

        return section;
    }
}
