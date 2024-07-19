package fr.lusuva.lusuvair.mapper.apimapper;

import java.time.LocalDateTime;

import fr.lusuva.lusuvair.dtos.apiweatherdto.ObservationDto;
import fr.lusuva.lusuvair.dtos.apiweatherdto.ResponseDto;
import fr.lusuva.lusuvair.dtos.apiweatherdto.WeatherTypeDto;
import fr.lusuva.lusuvair.entities.Weather;
import fr.lusuva.lusuvair.enums.WeatherType;

public class ApiWeatherMapper {
	
	public static Weather toWeather(ResponseDto responseDto,WeatherTypeDto weatherTypeDto) {
		   Weather weather = new Weather();		   
		   
		   weather.setAtmophericPressure(Integer.parseInt(weatherTypeDto.getObservationDto().getBarometerDto().getValue()));
		   weather.setHumidity(Integer.parseInt(weatherTypeDto.getObservationDto().getHumidityDto().getValue()));
		   weather.setTemperature(Integer.parseInt(weatherTypeDto.getObservationDto().getTemperatureDto().getValue()));
		   weather.setDate(LocalDateTime.parse(responseDto.getForecastDto().getDateTime()));
		   weather.setType(WeatherType.getWeatherType(responseDto.getForecastDto().getWeather()));
		   weather.setWind(responseDto.getForecastDto().getWind10m());		   
		   weather.setDirWind(responseDto.getForecastDto().getDirwind10m());
		   weather.setProbaRain(responseDto.getForecastDto().getProbarain());  
		   
		   return weather;  
	   }
	
	

}
