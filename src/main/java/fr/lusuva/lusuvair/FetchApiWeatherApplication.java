package fr.lusuva.lusuvair;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

import fr.lusuva.lusuvair.dtos.apiweatherdto.ResponseDto;
import fr.lusuva.lusuvair.dtos.apiweatherdto.WeatherTypeDto;
import fr.lusuva.lusuvair.entities.Weather;
import fr.lusuva.lusuvair.mapper.apimapper.ApiWeatherMapper;
import fr.lusuva.lusuvair.services.WeatherService;

@SpringBootApplication
public class FetchApiWeatherApplication  implements CommandLineRunner {

	@Autowired
	private WeatherService weatherService;
	
	@Value("${token.signing.key.apiWeather}")
	private String apiWeatherToken;
	
	public static void main(String[] args) {
		SpringApplication.run(FetchApiWeatherApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {

		        RestTemplate template = new RestTemplate();

        ResponseDto responseDto = template.getForObject(
                "https://api.meteo-concept.com/api/forecast/daily?token="+apiWeatherToken+"&insee=86010", ResponseDto.class);
        WeatherTypeDto[] weatherTypeDto = template.getForObject(
        		"https://api.meteo-concept.com/api/observations/around?token="+apiWeatherToken+"&insee&insee=86010&radius=50", WeatherTypeDto[].class);

        if (responseDto != null && weatherTypeDto != null) {        
        	Weather weather = ApiWeatherMapper.toWeather(responseDto, weatherTypeDto[0]);
            weatherService.insertNewWeather(weather);
        } else {
            System.out.println("Failed to fetch data");
        }        
    }


}
