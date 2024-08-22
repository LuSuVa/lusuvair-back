package fr.lusuva.lusuvair.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.lusuva.lusuvair.entities.AirQuality;
import fr.lusuva.lusuvair.entities.Weather;

/**
 * Repository interface for managing {@link AirQuality} entities.
 * 
 * @see AirQuality
 */
public interface AirQualityRepository extends JpaRepository<AirQuality, Integer> {
    
    /**
     * Deletes all {@link AirQuality} records with the specified date.
     *  
     * @param date the date of the {@link AirQuality} records to delete
     */
    void deleteByDate(String date); 
    
    AirQuality findByMunicipalityName(String name);
    
    List<AirQuality> findByMunicipalityNameContaining(String name);
}
