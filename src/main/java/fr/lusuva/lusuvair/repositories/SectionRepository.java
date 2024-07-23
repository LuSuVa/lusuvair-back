package fr.lusuva.lusuvair.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.lusuva.lusuvair.entities.Section;

/**
 * Repository interface for {@link Section} entities.
 * 
 * Provides methods to perform CRUD operations on {@link Section} entities.
 */
public interface SectionRepository extends JpaRepository<Section, Integer> {
    
}