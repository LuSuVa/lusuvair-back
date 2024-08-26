package fr.lusuva.lusuvair;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

import fr.lusuva.lusuvair.dtos.apiweatherdto.ResponseDto;
import fr.lusuva.lusuvair.dtos.apiweatherdto.WeatherTypeDto;
import fr.lusuva.lusuvair.entities.Municipality;
import fr.lusuva.lusuvair.entities.Weather;
import fr.lusuva.lusuvair.mappers.api.ApiWeatherMapper;
import fr.lusuva.lusuvair.services.MunicipalityService;
import fr.lusuva.lusuvair.services.WeatherService;

/**
 * The FetchApiWeatherApplication class fetches weather data from the Meteo
 * Concept API. It stores relevant weather information in a database.
 */
@SpringBootApplication
@EnableScheduling
public class FetchWeatherApiApplication implements CommandLineRunner {

	/**
	 * Service to handle weather-related database operations.
	 */
	@Autowired
	private WeatherService weatherService;

	/**
	 * API token for accessing the Meteo Concept API.
	 */
	@Value("${weather.api.token}")
	private String apiWeatherToken;

	/**
	 * API call
	 */
	@Value("${api.call}")
	private boolean apiCall;

	/**
	 * Weather API call
	 */
	@Value("${weather.api.call}")
	private boolean weatherApiCall;

	/**
	 * Service for handling operations related to municipalities.
	 */
	@Autowired
	private MunicipalityService municipalityService;

	/**
	 * Logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(FetchWeatherApiApplication.class);

	/**
	 * The main method that launches the Spring Boot application.
	 *
	 * @param args Command line arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(FetchWeatherApiApplication.class, args);
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
		if (apiCall && weatherApiCall) {
			fetchApiForEachMunicipalities();
		}
	}

	/**
	 * Scheduled task to fetch weather information for each municipality daily.
	 */
	@Scheduled(cron = "0 0 * * * ?")
	public void fetchApiForEachMunicipalities() {
		List<Municipality> municipalities = municipalityService.getMunicipalities();
		municipalities.forEach(this::fetchApi);
	}

	/**
	 * Fetches weather information from an external API for a given municipality.
	 *
	 * @param municipality The municipality object for which weather information is
	 *                     fetched.
	 */
	public void fetchApi(Municipality municipality) {
		logger.info("Begin fetch API Weather for " + municipality.getName());
		RestTemplate template = new RestTemplate();

		StringBuilder forecastStringBuilder = new StringBuilder();
		forecastStringBuilder.append("https://api.meteo-concept.com/api/forecast/daily?token=").append(apiWeatherToken)
				.append("&insee=").append(municipality.getInseeCode());

		StringBuilder observationsStringBuilder = new StringBuilder();
		observationsStringBuilder.append("https://api.meteo-concept.com/api/observations/around?token=")
				.append(apiWeatherToken).append("&insee=").append(municipality.getInseeCode()).append("&radius=50");

		ResponseDto responseDto = template.getForObject(forecastStringBuilder.toString(), ResponseDto.class);
		WeatherTypeDto[] weatherTypeDtos = template.getForObject(observationsStringBuilder.toString(),
				WeatherTypeDto[].class);

		if (responseDto != null && weatherTypeDtos != null) {
			try {
				int count = 0;
				WeatherTypeDto weatherTypeDto = weatherTypeDtos[count++];
				while (weatherTypeDto.getObservation() == null && count < weatherTypeDtos.length) {
					weatherTypeDto = weatherTypeDtos[count++];
				}

				Weather weather = ApiWeatherMapper.toWeather(responseDto, weatherTypeDto);
				weather.setMunicipality(municipality);
				weatherService.insertNewWeather(weather);

				logger.info("Successfully fetch !");
			} catch (Exception e) {
				logger.error("Failed to fetch API Weather");
			}
		} else {
			logger.error("Failed to fetch API Weather");
		}
	}
}
