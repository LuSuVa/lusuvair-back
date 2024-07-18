package fr.lusuva.lusuvair.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.lusuva.lusuvair.entities.Section;

public interface SectionRepository extends JpaRepository<Section, Integer> {
    
}
