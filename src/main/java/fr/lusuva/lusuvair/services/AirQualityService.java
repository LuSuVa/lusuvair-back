package fr.lusuva.lusuvair.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

import fr.lusuva.lusuvair.entities.AirQuality;
import fr.lusuva.lusuvair.repositories.AirQualityRepository;

/**
 * Service class for managing {@code AirQuality} entities.
 * 
 * This service provides methods to insert, delete, and retrieve AirQuality entities 
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
    
    /**
     * Retrieves all AirQuality entities from the database.
     * This method uses the AirQualityRepository to find all AirQuality entities.
     *
     * @return a list of all AirQuality entities
     */
    public List<AirQuality> getAll() {
        return airQualityRepository.findAll();
    }
    
    /**
     * Retrieves an AirQuality entity by its ID.
     * This method uses the AirQualityRepository to find an AirQuality entity by its ID.
     *
     * @param id the ID of the AirQuality entity to be retrieved
     * @return the AirQuality entity with the given ID
     * @throws NoSuchElementException if no AirQuality entity is found with the given ID
     */
    public AirQuality getById(int id) throws NoSuchElementException {
        AirQuality airQuality = airQualityRepository.findById(id).orElse(null);

        if (airQuality == null) {
            throw new NoSuchElementException("Could not find airQuality");
        }

        return airQuality;
    }
}
