package fr.lusuva.lusuvair.mapper.apimapper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import fr.lusuva.lusuvair.dtos.apiweatherdto.ObservationDto;
import fr.lusuva.lusuvair.dtos.apiweatherdto.ResponseDto;
import fr.lusuva.lusuvair.dtos.apiweatherdto.WeatherTypeDto;
import fr.lusuva.lusuvair.entities.Weather;
import fr.lusuva.lusuvair.enums.WeatherType;

/**
 * Utility class for mapping data transfer objects (DTOs) from the weather API to the internal {@link Weather} entity.
 */
public class ApiWeatherMapper {

    /**
     * Converts a {@link ResponseDto} and a {@link WeatherTypeDto} into a {@link Weather} entity.
     * 
     * @param responseDto the {@link ResponseDto} object containing weather forecast data
     * @param weatherTypeDto the {@link WeatherTypeDto} object containing weather type and observation data
     * @return a {@link Weather} entity with fields populated from the DTOs
     */
    public static Weather toWeather(ResponseDto responseDto, WeatherTypeDto weatherTypeDto) {
        Weather weather = new Weather();
        
        // Check if observation data is of type ObservationDto and extract relevant data
        if (weatherTypeDto.getObservation() instanceof ObservationDto) {
            ObservationDto observation = (ObservationDto) weatherTypeDto.getObservation();
            weather.setAtmophericPressure(Double.parseDouble(observation.getBarometer().getValue()));
            weather.setHumidity(Double.parseDouble(observation.getHumidity().getValue()));
            weather.setTemperature(Double.parseDouble(observation.getTemperature().getValue()));
        }
        
        // Parse date from the forecast data
        weather.setDate(LocalDateTime.parse(responseDto.getForecast()[0].getDatetime(), DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssZ")));
        
        // Set weather type from the forecast data using WeatherType enum
        weather.setType(WeatherType.getWeatherType(responseDto.getForecast()[0].getWeather()));
        
        // Set other weather-related fields
        weather.setWind(responseDto.getForecast()[0].getWind10m());
        weather.setDirWind(responseDto.getForecast()[0].getDirwind10m());
        weather.setProbaRain(responseDto.getForecast()[0].getProbarain());
        
        return weather;  
    }
}
