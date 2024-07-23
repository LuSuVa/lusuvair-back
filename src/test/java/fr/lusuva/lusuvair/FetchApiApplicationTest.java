package fr.lusuva.lusuvair;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times; // Import for times
import static org.mockito.ArgumentMatchers.any; // Import for any
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;

import fr.lusuva.lusuvair.dtos.apidto.ParticleDto;
import fr.lusuva.lusuvair.dtos.apidto.WaqiDataDto;
import fr.lusuva.lusuvair.entities.AirQuality;
import fr.lusuva.lusuvair.entities.Municipality;
import fr.lusuva.lusuvair.entities.Particle;
import fr.lusuva.lusuvair.services.AirQualityService;
import fr.lusuva.lusuvair.services.MunicipalityService;
import fr.lusuva.lusuvair.services.ParticleService;

public class FetchApiApplicationTest {

	@Mock
	private ParticleService particleService;

	@Mock
	private AirQualityService airQualityService;

	@Mock
	private MunicipalityService municipalityService;

	@Mock
	private RestTemplate restTemplate;

	@InjectMocks
	private FetchApiApplication fetchApiApplication;

	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void testAddParticle_ValidParticle() {
		Map<String, Double> particles = new HashMap<>();
		ParticleDto particleDto = new ParticleDto();
		particleDto.setV(10.0);

		fetchApiApplication.addParticleToMap(particles, "pm10", particleDto);

		assertEquals(1, particles.size());
		assertEquals(10.0, particles.get("pm10"));
	}

	@Test
	public void testAddParticle_NullParticle() {
		Map<String, Double> particles = new HashMap<>();
		fetchApiApplication.addParticleToMap(particles, "pm10", null);

		assertTrue(particles.isEmpty());
	}

	@Test
	public void testAddParticleToMap_ZeroValueParticle() {
		Map<String, Double> particles = new HashMap<>();
		ParticleDto particleDto = new ParticleDto();
		particleDto.setV(0.0);

		fetchApiApplication.addParticleToMap(particles, "pm10", particleDto);

		assertTrue(particles.isEmpty());
	}

	@Test
	public void testFetchDataAndPersist_SuccessfulFetch() {
		Municipality municipality = new Municipality();
		municipality.setName("Paris");
		when(municipalityService.getMunicipalities()).thenReturn(Arrays.asList(municipality));

		WaqiDataDto waqiData = new WaqiDataDto();
		waqiData.setStatus("ok");
		assertEquals("ok", waqiData.getStatus());
		when(restTemplate.getForObject(
				"http://api.waqi.info/feed/Paris/?token=01eb30b0ce9ad323162d0394e6b3446231f203cf", WaqiDataDto.class))
				.thenReturn(waqiData);
		fetchApiApplication.fetchDataAndPersist();

		verify(particleService, times(10)).insertParticle(any(Particle.class));
		verify(airQualityService, times(1)).insertAirQuality(any(AirQuality.class));
	}

}
