package fr.lusuva.lusuvair.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.lusuva.lusuvair.entities.Weather;
import fr.lusuva.lusuvair.repositories.WeatherRepository;

/**
 * Service for managing weather data.
 * 
 * This service provides methods to interact with weather data in the database,
 * specifically for inserting new weather records.
 */
@Service
public class WeatherService {

    /**
     * Repository for accessing Weather entities.
     */
    @Autowired
    private WeatherRepository weatherRepository;
    
    /**
     * Inserts a new Weather entity into the database.
     * 
     * This method uses the WeatherRepository to persist the given Weather entity.
     * 
     * @param weather the Weather entity to be inserted
     */
    public void insertNewWeather(Weather weather) {
        weatherRepository.save(weather);
    }
}
