package fr.lusuva.lusuvair.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.lusuva.lusuvair.entities.Municipality;
import fr.lusuva.lusuvair.entities.Weather;

/**
 * Repository interface for managing {@link Weather} entities.
 */
public interface WeatherRepository extends JpaRepository<Weather, Integer> {
	
    /**
     * Finds a {@link Weather} entity by its id.
     * 
     * @param id the id of the Weather entity
     * @return the Weather entity with the specified id, or {@code null} if none found
     */
    Weather findById(int id);
    
    /**
     * Finds a {@link Weather} entity by its associated {@link Municipality}.
     * 
     * @param municipality the municipality associated with the Weather entity
     * @return the Weather entity associated with the specified municipality, or {@code null} if none found
     */
    Weather findByMunicipality(Municipality municipality);
}
