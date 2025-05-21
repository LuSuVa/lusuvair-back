package fr.lusuva.lusuvair.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

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
    void testInsertAirQuality() {
        AirQuality airQuality = new AirQuality();
        airQualityService.insertAirQuality(airQuality);
        verify(airQualityRepository, times(1)).save(airQuality);
    }

    @Test
    void testDeleteByDate() {
        String date = "2023-01-01";
        airQualityService.deleteByDate(date);
        verify(airQualityRepository, times(1)).deleteByDate(date);
    }
    
    @Test
    void testGetAll() {
        List<AirQuality> list = Arrays.asList(new AirQuality(), new AirQuality());
        when(airQualityRepository.findAll()).thenReturn(list);

        List<AirQuality> result = airQualityService.getAll();

        assertEquals(2, result.size());
        verify(airQualityRepository, times(1)).findAll();
    }

    @Test
    void testGetByIdFound() {
        AirQuality airQuality = new AirQuality();
        airQuality.setId(1);

        when(airQualityRepository.findById(1)).thenReturn(Optional.of(airQuality));

        AirQuality result = airQualityService.getById(1);

        assertEquals(1, result.getId());
    }

    @Test
    void testGetByIdNotFound() {
        when(airQualityRepository.findById(1)).thenReturn(Optional.empty());

        assertThrows(NoSuchElementException.class, () -> airQualityService.getById(1));
    }

    @Test
    void testGetByMunicipalityNameFound() {
        AirQuality aq1 = new AirQuality();
        aq1.setDate("2023-01-01 10:00:00");

        AirQuality aq2 = new AirQuality();
        aq2.setDate("2023-01-02 12:00:00");

        List<AirQuality> mockList = Arrays.asList(aq1, aq2);

        when(airQualityRepository.findByMunicipalityNameContaining("Paris")).thenReturn(mockList);

        AirQuality result = airQualityService.getByMunicipalityName("Paris");

        assertEquals("2023-01-02 12:00:00", result.getDate());
    }

    @Test
    void testGetByMunicipalityNameNotFound() {
        when(airQualityRepository.findByMunicipalityNameContaining("Unknown")).thenReturn(Collections.emptyList());

        assertThrows(NoSuchElementException.class, () -> airQualityService.getByMunicipalityName("Unknown"));
    }
}
