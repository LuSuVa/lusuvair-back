package fr.lusuva.lusuvair.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.lusuva.lusuvair.entities.Weather;
import fr.lusuva.lusuvair.repositories.WeatherRepository;

@Service
public class WeatherService {

	@Autowired
	private WeatherRepository weatherRepository;
	
	public void insertNewWeather(Weather weather) {
		weatherRepository.save(weather);
	}
}
