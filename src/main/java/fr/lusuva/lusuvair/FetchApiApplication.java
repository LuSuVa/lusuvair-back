package fr.lusuva.lusuvair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
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
 * The FetchApiApplication class fetches air quality data from waqi API. It
 * stores relevant particle information in a database.
 */
@SpringBootApplication
@EnableScheduling
public class FetchApiApplication implements CommandLineRunner {

	@Autowired
	private ParticleService particleService;
	@Autowired
	private AirQualityService airQualityService;
	@Autowired
	private MunicipalityService municipalityService;

	/**
	 * The main method that launches the Spring Boot application.
	 */
	public static void main(String[] args) {
		SpringApplication.run(FetchApiApplication.class, args);
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
	fetchDataAndPersist();
	}
	
	@Scheduled(cron = "0 */30 * * * ?")
		public void fetchDataAndPersist() {	
		List<Municipality> municipalities = municipalityService.getMunicipalities();
		for (Municipality municipality : municipalities) {
			String cityName = municipality.getName();
			RestTemplate template = new RestTemplate();
			WaqiDataDto waqiData = template.getForObject(
					"http://api.waqi.info/feed/"+cityName+"/?token=01eb30b0ce9ad323162d0394e6b3446231f203cf",
					WaqiDataDto.class);

			if (waqiData != null && "ok".equals(waqiData.getStatus())) {
				IaqiDto iaqi = waqiData.getDataDto().getIaqi();
				Map<String, Double> particles = new HashMap<>();

				if (iaqi != null) {
					addParticleToMap(particles, "dew", iaqi.getDew());
					addParticleToMap(particles, "h", iaqi.getH());
					addParticleToMap(particles, "no2", iaqi.getNo2());
					addParticleToMap(particles, "o3", iaqi.getO3());
					addParticleToMap(particles, "p", iaqi.getP());
					addParticleToMap(particles, "pm10", iaqi.getPm10());
					addParticleToMap(particles, "pm25", iaqi.getPm25());
					addParticleToMap(particles, "so2", iaqi.getSo2());
					addParticleToMap(particles, "t", iaqi.getT());
					addParticleToMap(particles, "w", iaqi.getW());
					addParticleToMap(particles, "wg", iaqi.getWg());
				}
				String date  = waqiData.getDataDto().getTime().getS();
//				airQualityService.deleteByDate(date);
				
				AirQuality airQuality = new AirQuality();
				airQuality.setDate(date);
				airQuality.setMunicipality(municipality);
				
				List<Particle> particleEntities = new ArrayList<>();
				for(Map.Entry<String, Double> entry : particles.entrySet()) {
					Particle particle= new Particle();
					particle.setName(entry.getKey());
					particle.setQuantity(entry.getValue());
//					particleService.deleteByNameAndQuantity(entry.getKey(),entry.getValue());
					particleService.insertParticle(particle);
					particleEntities.add(particle);
				}
				airQuality.setParticles(particleEntities);
						
				airQualityService.insertAirQuality(airQuality);
			} else {
				System.out.println("Failed to fetch data or status is not ok");
			}
			
		}
		}
	
	

	/**
	 * Adds a particles data and persists it to the database if the particle data is
	 * not null and has a non-zero value.
	 *
	 * @param particles   Map to store particle data
	 * @param key         Representing the name of the particle
	 * @param particleDto Containing particle information
	 */
	private void addParticleToMap(Map<String, Double> particles, String key, ParticleDto particleDto) {
		if (particleDto != null && particleDto.getV() != 0) {
			particles.put(key, particleDto.getV());
			Particle particleEntity = new Particle();
			particleEntity.setName(key);
			particleEntity.setQuantity(particleDto.getV());
		}
	}

}
