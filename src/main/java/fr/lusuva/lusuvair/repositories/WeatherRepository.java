package fr.lusuva.lusuvair.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.lusuva.lusuvair.entities.AirQuality;
import fr.lusuva.lusuvair.entities.Weather;

/**
 * Repository interface for managing Weather entities.
 */
public interface WeatherRepository extends JpaRepository<Weather, Integer> {
    
    /**
     * Finds a Weather entity by its ID.
     * 
     * @param id the ID of the Weather entity
     * @return the Weather entity with the specified ID, or {@code null} if none found
     */
    Weather findById(int id);
    
    /**
     * Finds a Weather entity by the ID of its associated Municipality.
     * 
     * @param id the ID of the Municipality
     * @return the Weather entity associated with the specified Municipality ID, or {@code null} if none found
     */
    Weather findByMunicipalityId(int id);
    
    /**
     * Finds a Weather entity by the name of its associated Municipality.
     * 
     * @param name the name of the Municipality
     * @return the Weather entity associated with the specified Municipality name, or {@code null} if none found
     */
    Weather findByMunicipalityName(String name);
    
    List<Weather> findByMunicipalityNameContaining(String name);
}
