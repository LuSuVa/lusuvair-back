package fr.lusuva.lusuvair;

import java.util.ArrayList;
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

import fr.lusuva.lusuvair.dtos.apidto.IaqiDto;
import fr.lusuva.lusuvair.dtos.apidto.ParticleDto;
import fr.lusuva.lusuvair.dtos.apidto.WaqiDataDto;
import fr.lusuva.lusuvair.entities.AirQuality;
import fr.lusuva.lusuvair.entities.Municipality;
import fr.lusuva.lusuvair.entities.Particle;
import fr.lusuva.lusuvair.services.AirQualityService;
import fr.lusuva.lusuvair.services.MunicipalityService;
import fr.lusuva.lusuvair.services.ParticleService;

/**
 * The FetchApiApplication class fetches air quality data from the WAQI API. It
 * stores relevant particle information in a database.
 */
@SpringBootApplication
@EnableScheduling
public class FetchWaqiApiApplication implements CommandLineRunner {

	/**
	 * Service to handle particle-related database operations.
	 */
	@Autowired
	private ParticleService particleService;

	/**
	 * Service to handle air-quality-related database operations.
	 */
	@Autowired
	private AirQualityService airQualityService;

	/**
	 * Service to handle municipality-related database operations.
	 */
	@Autowired
	private MunicipalityService municipalityService;

	/**
	 * API call
	 */
	@Value("${api.call}")
	private boolean apiCall;

	/**
	 * WAQI API call
	 */
	@Value("${waqi.api.call}")
	private boolean waqiApiCall;

	/**
	 * Logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(FetchWaqiApiApplication.class);

	/**
	 * The main method that launches the Spring Boot application.
	 *
	 * @param args Command line arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(FetchWaqiApiApplication.class, args);
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
		if (apiCall && waqiApiCall) {
			fetchApiForEachMunicipalities();
		}
	}

	/**
	 * This method fetches air quality data from the WAQI API for each municipality
	 * and persists it to the database. It is scheduled to run every 30 minutes.
	 */
	@Scheduled(cron = "0 0 * * * ?")
	public void fetchApiForEachMunicipalities() {
		List<Municipality> municipalities = municipalityService.getMunicipalities();
		municipalities.forEach(this::fetchDataAndPersist);
	}

	/**
	 * This method fetches air quality data from the WAQI API for a municipality and
	 * persists it to the database.
	 */
	public void fetchDataAndPersist(Municipality municipality) {
		logger.info("Begin fetch API Waqi for " + municipality.getName());
		RestTemplate template = new RestTemplate();

		StringBuilder urlRequest = new StringBuilder("http://api.waqi.info/feed/");
		urlRequest.append(municipality.getName()).append("/?token=01eb30b0ce9ad323162d0394e6b3446231f203cf");

		WaqiDataDto waqiData = template.getForObject(urlRequest.toString(), WaqiDataDto.class);

		if (waqiData != null && "ok".equals(waqiData.getStatus())) {
			IaqiDto iaqi = waqiData.getDataDto().getIaqi();
			List<Particle> particles = new ArrayList<>();

			if (iaqi != null) {

				particles.add(buildParticle("no2", iaqi.getNo2()));
				particles.add(buildParticle("o3", iaqi.getO3()));
				particles.add(buildParticle("pm10", iaqi.getPm10()));
				particles.add(buildParticle("pm25", iaqi.getPm25()));
				particles.add(buildParticle("so2", iaqi.getSo2()));
				particles.add(buildParticle("t", iaqi.getT()));
				particles.add(buildParticle("h", iaqi.getH()));
				particles.add(buildParticle("p", iaqi.getP()));
				particles.add(buildParticle("w", iaqi.getW()));
				particles.add(buildParticle("wg", iaqi.getWg()));
				particles.add(buildParticle("dew", iaqi.getDew()));
								
			}

			String date = waqiData.getDataDto().getTime().getS();

			AirQuality airQuality = new AirQuality();
			airQuality.setDate(date);
			airQuality.setMunicipality(municipality);
			airQuality.setAqi(waqiData.getDataDto().getAqi());
			particles.forEach(particleService::insertParticle);
			airQuality.setParticles(particles);

			airQualityService.insertAirQuality(airQuality);

			logger.info("Fetched AQI: " + waqiData.getDataDto().getAqi());
			logger.info("Successfully fetch !");
		} else {
			logger.error("Failed to fetch API Waqi");
		}
	}

	/**
	 * Builds particle data if the particle data is not null and has a non-zero
	 * value.
	 *
	 * @param key         The name of the particle
	 * @param particleDto The particle data transfer object containing particle
	 *                    information
	 */
	public Particle buildParticle(String key, ParticleDto particleDto) {
		if (particleDto != null && particleDto.getV() != 0) {
			Particle particleEntity = new Particle();
			particleEntity.setName(key);
			particleEntity.setQuantity(particleDto.getV());
			return particleEntity;
		}
		return null;
	}
}
