package fr.lusuva.lusuvair.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.lusuva.lusuvair.dtos.section.SectionPostDto;
import fr.lusuva.lusuvair.entities.Section;
import fr.lusuva.lusuvair.entities.UserAccount;
import fr.lusuva.lusuvair.repositories.SectionRepository;

@Service
public class SectionService {
    
    @Autowired
    private SectionRepository sectionRepository;

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
