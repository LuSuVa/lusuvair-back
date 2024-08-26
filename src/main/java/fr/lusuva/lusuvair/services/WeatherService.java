package fr.lusuva.lusuvair.services;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.lusuva.lusuvair.entities.Weather;
import fr.lusuva.lusuvair.repositories.WeatherRepository;

/**
 * Service for managing weather data.
 * 
 * This service provides methods to interact with weather data in the database,
 * including inserting, retrieving, updating, and deleting weather records.
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
     * @param weather the Weather entity to be inserted
     */
    public void insertNewWeather(Weather weather) {
        weatherRepository.save(weather);
    }

    /**
     * Retrieves all Weather entities from the database.
     * 
     * @return a list of all Weather entities
     */
    public List<Weather> getAll() {
        return weatherRepository.findAll();
    }

    /**
     * Retrieves a Weather entity by its ID.
     * 
     * @param id the ID of the Weather entity
     * @return the Weather entity with the specified ID
     * @throws NoSuchElementException if no Weather entity with the specified ID is
     *                                found
     */
    public Weather getById(int id) throws NoSuchElementException {
        Weather weather = weatherRepository.findById(id);
        if (weather == null) {
            throw new NoSuchElementException("Could not find Weather with ID " + id);
        }
        return weather;
    }

    /**
     * Updates a Weather entity with new data.
     * 
     * @param id         the ID of the Weather entity to be updated
     * @param newWeather the new Weather entity with updated data
     * @return the updated Weather entity
     */
    public Weather updateById(int id, Weather newWeather) {
        Weather weather = getById(id);

        weather.setAtmophericPressure(newWeather.getAtmophericPressure());
        weather.setDate(newWeather.getDate());
        weather.setDirWind(newWeather.getDirWind());
        weather.setHumidity(newWeather.getHumidity());
        weather.setProbaRain(newWeather.getProbaRain());
        weather.setTemperature(newWeather.getTemperature());
        weather.setType(newWeather.getType());
        weather.setWind(newWeather.getWind());

        weatherRepository.save(weather);

        return weather;
    }

    /**
     * Retrieves a Weather entity by the ID of its associated Municipality.
     * 
     * @param idMunicipality the ID of the Municipality
     * @return the Weather entity associated with the specified Municipality ID
     */
    public Weather getByMunicipalityId(int idMunicipality) {
        return weatherRepository.findByMunicipalityId(idMunicipality);
    }

    /**
     * Retrieves a Weather entity by the name of its associated Municipality.
     * 
     * @param name the name of the Municipality
     * @return the Weather entity associated with the specified Municipality name
     */
    public Weather getByMunicipalityName(String name) {
        List<Weather> weathers = weatherRepository.findByMunicipalityNameContaining(name);

        if (weathers.isEmpty()) {
            throw new NoSuchElementException("No weather data found for municipality: " + name);
        }

        return weathers.stream().sorted(Comparator.comparing(Weather::getDate).reversed()).findFirst().orElse(null);
    }

    /**
     * Deletes a Weather entity by its ID.
     * 
     * @param id the ID of the Weather entity to be deleted
     */
    public void deleteById(int id) {
        Weather weather = getById(id);
        weatherRepository.delete(weather);
    }
}
