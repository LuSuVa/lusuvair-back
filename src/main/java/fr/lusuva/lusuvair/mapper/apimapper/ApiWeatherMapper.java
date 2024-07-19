package fr.lusuva.lusuvair.mapper.apimapper;

import java.time.LocalDateTime;

import fr.lusuva.lusuvair.dtos.apiweatherdto.ObservationDto;
import fr.lusuva.lusuvair.dtos.apiweatherdto.ResponseDto;
import fr.lusuva.lusuvair.entities.Weather;
import fr.lusuva.lusuvair.enums.WeatherType;

public class ApiWeatherMapper {
	
	public Weather toWeather(ResponseDto responseDto,ObservationDto observationDto) {
		   Weather weather = new Weather();		   
		   
		   weather.setAtmophericPressure(Integer.parseInt(observationDto.getBarometerDto().getValue()));
		   weather.setHumidity(Integer.parseInt(observationDto.getHumidityDto().getValue()));
		   weather.setTemperature(Integer.parseInt(observationDto.getTemperatureDto().getValue()));
		   weather.setDate(LocalDateTime.parse(responseDto.getForecastDto().getDateTime()));
		   weather.setType(WeatherType.getWeatherType(responseDto.getForecastDto().getWeather()));
		   weather.setWind(responseDto.getForecastDto().getWind10m());		   
		   weather.setDirWind(responseDto.getForecastDto().getDirwind10m());
		   weather.setProbaRain(responseDto.getForecastDto().getProbarain());  
		   
		   return weather;  
	   }
	
	

}
