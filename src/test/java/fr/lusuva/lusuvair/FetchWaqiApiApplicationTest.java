package fr.lusuva.lusuvair;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any; // Import for any
import static org.mockito.Mockito.times; // Import for times
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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

public class FetchWaqiApiApplicationTest {

	@Mock
	private ParticleService particleService;

	@Mock
	private AirQualityService airQualityService;

	@Mock
	private MunicipalityService municipalityService;

	@Mock
	private RestTemplate restTemplate;

	@InjectMocks
	private FetchWaqiApiApplication fetchWaqiApiApplication;

	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void testBuildParticle_ValidParticle() {
		ParticleDto particleDto = new ParticleDto();
		particleDto.setV(10.0);
		
		Particle particle = fetchWaqiApiApplication.buildParticle("pm10", particleDto,"µg/m³");

		assertEquals("pm10", particle.getName());
		assertEquals(10.0, particle.getQuantity());
	}

	@Test
	public void testBuildParticle_NullParticle() {
		Particle particle = fetchWaqiApiApplication.buildParticle("pm10", null,"µg/m³");

		assertTrue(particle == null);
	}

	@Test
	public void testBuildParticleToMap_ZeroValueParticle() {
		ParticleDto particleDto = new ParticleDto();
		particleDto.setV(0.0);

		Particle particle = fetchWaqiApiApplication.buildParticle("pm10", particleDto,"µg/m³");

		assertTrue(particle == null);
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
		fetchWaqiApiApplication.fetchDataAndPersist(municipality);

		verify(particleService, times(9)).insertParticle(any(Particle.class));
		verify(airQualityService, times(1)).insertAirQuality(any(AirQuality.class));
	}

}
