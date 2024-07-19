package fr.lusuva.lusuvair.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.lusuva.lusuvair.entities.Weather;
import fr.lusuva.lusuvair.repositories.WeatherRepository;
import jakarta.annotation.PostConstruct;

@Service
public class WeatherService {

	@Autowired
	private WeatherRepository weatherRepository;
	
	public void insertNewWeather(Weather weather) {
		weatherRepository.save(weather);
	}
}
