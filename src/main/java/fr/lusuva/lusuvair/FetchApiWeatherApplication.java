package fr.lusuva.lusuvair;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

import fr.lusuva.lusuvair.dtos.apiweatherdto.ResponseDto;
import fr.lusuva.lusuvair.dtos.apiweatherdto.WeatherTypeDto;
import fr.lusuva.lusuvair.entities.Weather;
import fr.lusuva.lusuvair.mapper.apimapper.ApiWeatherMapper;
import fr.lusuva.lusuvair.services.WeatherService;

@SpringBootApplication
public class FetchApiWeatherApplication {

	@Autowired
	private WeatherService weatherService;
	
	public static void main(String[] args) {
		System.out.println("coucou");
		SpringApplication.run(FetchApiWeatherApplication.class, args);
	}
	
	public void run(String... args) throws Exception {
		System.out.println("coucou");
        RestTemplate template = new RestTemplate();
        
        ResponseDto responseDto = template.getForObject(
                "https://api.meteo-concept.com/api/forecast/daily?token=076df100be13505fb6674558c0f1a649cdec96f3b4d867a3a09818e081715410&insee=86010", ResponseDto.class);
        WeatherTypeDto weatherTypeDto = template.getForObject(
        		"https://api.meteo-concept.com/api/observations/around?token=076df100be13505fb6674558c0f1a649cdec96f3b4d867a3a09818e081715410&insee&insee=86010&radius=50", WeatherTypeDto.class);

        if (responseDto != null && weatherTypeDto != null) {        
        	Weather weather = ApiWeatherMapper.toWeather(responseDto, weatherTypeDto);
            weatherService.insertNewWeather(weather);
        } else {
            System.out.println("Failed to fetch data or status is not ok");
        }        
    }


}
