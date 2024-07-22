package fr.lusuva.lusuvair.mapper.apimapper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import fr.lusuva.lusuvair.dtos.apiweatherdto.ObservationDto;
import fr.lusuva.lusuvair.dtos.apiweatherdto.ResponseDto;
import fr.lusuva.lusuvair.dtos.apiweatherdto.WeatherTypeDto;
import fr.lusuva.lusuvair.entities.Weather;
import fr.lusuva.lusuvair.enums.WeatherType;

public class ApiWeatherMapper {
	
	public static Weather toWeather(ResponseDto responseDto,WeatherTypeDto weatherTypeDto) {
		   Weather weather = new Weather();		   
		   
		   if(weatherTypeDto.getObservation() instanceof ObservationDto) {
			   
			   ObservationDto observation = (ObservationDto) weatherTypeDto.getObservation();
			   weather.setAtmophericPressure(Double.parseDouble(observation.getBarometer().getValue()));
			   weather.setHumidity(Double.parseDouble(observation.getHumidity().getValue()));
			   weather.setTemperature(Double.parseDouble(observation.getTemperature().getValue()));
		   }
		   
		   weather.setDate(LocalDateTime.parse(responseDto.getForecast()[0].getDatetime(),DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssZ")));
		   weather.setType(WeatherType.getWeatherType(responseDto.getForecast()[0].getWeather()));
		   weather.setWind(responseDto.getForecast()[0].getWind10m());		   
		   weather.setDirWind(responseDto.getForecast()[0].getDirwind10m());
		   weather.setProbaRain(responseDto.getForecast()[0].getProbarain());
		   
		   return weather;  
	   }
	
	

}
