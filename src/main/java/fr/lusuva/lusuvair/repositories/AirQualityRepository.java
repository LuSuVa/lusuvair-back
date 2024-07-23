package fr.lusuva.lusuvair.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.lusuva.lusuvair.entities.AirQuality;

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
}
