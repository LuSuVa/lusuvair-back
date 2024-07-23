package fr.lusuva.lusuvair.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import fr.lusuva.lusuvair.entities.Municipality;

/**
 * Repository interface for {@link Municipality} entities.
 * 
 * Provides methods to perform CRUD operations on {@link Municipality} entities.
 */
public interface MunicipalityRepository extends JpaRepository<Municipality, Integer> {

}
