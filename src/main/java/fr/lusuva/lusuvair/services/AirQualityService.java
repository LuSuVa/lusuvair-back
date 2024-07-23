package fr.lusuva.lusuvair.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

import fr.lusuva.lusuvair.entities.AirQuality;
import fr.lusuva.lusuvair.repositories.AirQualityRepository;

/**
 * Service class for managing {@code AirQuality} entities.
 * 
 * This service provides methods to insert and delete AirQuality entities 
 * from the database using the AirQualityRepository.
 */
@Service
public class AirQualityService {

    @Autowired
    private AirQualityRepository airQualityRepository;

    /**
     * Inserts a new AirQuality entity into the database.
     * This method uses the AirQualityRepository to save the given AirQuality entity.
     *
     * @param airQuality the AirQuality entity to be inserted
     */
    public void insertAirQuality(AirQuality airQuality) {
        airQualityRepository.save(airQuality);
    }
    
    /**
     * Deletes AirQuality entities by the given date.
     * This method uses the AirQualityRepository to delete entities based on the provided date.
     *
     * @param date the date of the AirQuality entities to be deleted
     */
    @Transactional
    public void deleteByDate(String date) {
        airQualityRepository.deleteByDate(date);
    }
}
