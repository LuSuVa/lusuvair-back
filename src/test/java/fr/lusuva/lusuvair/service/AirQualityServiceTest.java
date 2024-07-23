package fr.lusuva.lusuvair.service;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import fr.lusuva.lusuvair.entities.AirQuality;
import fr.lusuva.lusuvair.repositories.AirQualityRepository;
import fr.lusuva.lusuvair.services.AirQualityService;

public class AirQualityServiceTest {

    @Mock
    private AirQualityRepository airQualityRepository;

    @InjectMocks
    private AirQualityService airQualityService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testInsertAirQuality() {
        AirQuality airQuality = new AirQuality();
        
        assertDoesNotThrow(() -> airQualityService.insertAirQuality(airQuality));

        verify(airQualityRepository).save(any(AirQuality.class));
    }

    @Test
    public void testDeleteByDate() {
        String date = "2024-07-21";

        assertDoesNotThrow(() -> airQualityService.deleteByDate(date));

        verify(airQualityRepository).deleteByDate(eq(date));
    }
}
