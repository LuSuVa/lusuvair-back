package fr.lusuva.lusuvair.services;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import fr.lusuva.lusuvair.entities.AirQuality;
import fr.lusuva.lusuvair.entities.Particle;
import fr.lusuva.lusuvair.repositories.AirQualityRepository;
import jakarta.transaction.Transactional;

@Service
public class AirQualityService {

    @Autowired
    private AirQualityRepository airQualityRepository;

    /**
     * Inserts a new AirQuality entity in database.
     * This method uses the AirQualityRepository to save the given AirQuality entity.
     *
     * @param AirQuality entity to be inserted
     */
    public void insertAirQuality(AirQuality airQuality) {
    	airQualityRepository.save(airQuality);
    }
    
    @Transactional
    public void deleteByDate(String Date) {
    	airQualityRepository.deleteByDate(Date);
    }
    
}
