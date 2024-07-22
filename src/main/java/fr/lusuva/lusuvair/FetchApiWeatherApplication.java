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

/**
 * The FetchApiWeatherApplication class fetches weather data from the Meteo Concept API.
 * It stores relevant weather information in a database.
 */
@SpringBootApplication
public class FetchApiWeatherApplication implements CommandLineRunner {

    /**
     * Service to handle weather-related database operations.
     */
    @Autowired
    private WeatherService weatherService;

    /**
     * API token for accessing the Meteo Concept API.
     */
    @Value("${token.signing.key.apiWeather}")
    private String apiWeatherToken;

    /**
     * The main method that launches the Spring Boot application.
     *
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(FetchApiWeatherApplication.class, args);
    }

    /**
     * This method is executed after the application context is loaded and right
     * before the Spring Boot application starts.
     *
     * @param args Command line arguments
     * @throws Exception if an error occurs during data fetching or processing
     */
    @Override
    public void run(String... args) throws Exception {
        RestTemplate template = new RestTemplate();

        ResponseDto responseDto = template.getForObject(
            "https://api.meteo-concept.com/api/forecast/daily?token=" + apiWeatherToken + "&insee=86010",
            ResponseDto.class
        );
        WeatherTypeDto[] weatherTypeDto = template.getForObject(
            "https://api.meteo-concept.com/api/observations/around?token=" + apiWeatherToken + "&insee=86010&radius=50",
            WeatherTypeDto[].class
        );

        if (responseDto != null && weatherTypeDto != null) {
            Weather weather = ApiWeatherMapper.toWeather(responseDto, weatherTypeDto[0]);
            weatherService.insertNewWeather(weather);
        } else {
            System.out.println("Failed to fetch data");
        }
    }
}
