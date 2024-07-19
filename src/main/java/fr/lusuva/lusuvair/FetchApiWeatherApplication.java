package fr.lusuva.lusuvair;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

import fr.lusuva.lusuvair.dtos.apiweatherdto.ObservationDto;
import fr.lusuva.lusuvair.dtos.apiweatherdto.ResponseDto;
import fr.lusuva.lusuvair.entities.Weather;
import fr.lusuva.lusuvair.mapper.apimapper.ApiWeatherMapper;
import fr.lusuva.lusuvair.repositories.WeatherRepository;

@SpringBootApplication
public class FetchApiWeatherApplication {

	@Autowired
	private WeatherRepository weatherRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(FetchApiWeatherApplication.class, args);
	}
	
	public void run(String... args) throws Exception {
        RestTemplate template = new RestTemplate();
        
        ResponseDto responseDto = template.getForObject(
                "https://api.meteo-concept.com/api/forecast/daily?token=076df100be13505fb6674558c0f1a649cdec96f3b4d867a3a09818e081715410&insee=35238", ResponseDto.class);
        ObservationDto observationDto = template.getForObject(
        		"https://api.meteo-concept.com/api/observations/around?token=076df100be13505fb6674558c0f1a649cdec96f3b4d867a3a09818e081715410&insee&insee=35238&radius=50", ObservationDto.class);

        if (responseDto != null && observationDto != null) {        
        	Weather weather = ApiWeatherMapper.toWeather(responseDto, observationDto);
        } else {
            System.out.println("Failed to fetch data or status is not ok");
        }
        
    }


}
