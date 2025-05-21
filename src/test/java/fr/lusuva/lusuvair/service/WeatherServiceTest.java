package fr.lusuva.lusuvair.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import fr.lusuva.lusuvair.entities.Weather;
import fr.lusuva.lusuvair.enums.WeatherType;
import fr.lusuva.lusuvair.repositories.WeatherRepository;
import fr.lusuva.lusuvair.services.WeatherService;

public class WeatherServiceTest {

    @Mock
    private WeatherRepository weatherRepository;

    @InjectMocks
    private WeatherService weatherService;

    private Weather sampleWeather;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);

        sampleWeather = new Weather();
        sampleWeather.setId(1);
        sampleWeather.setAtmophericPressure(1013.0);
        sampleWeather.setDate(LocalDateTime.now());
        sampleWeather.setDirWind(90);
        sampleWeather.setHumidity(75);
        sampleWeather.setProbaRain(20);
        sampleWeather.setTemperature(23.5);
        sampleWeather.setType(WeatherType.SUNNY);
        sampleWeather.setWind(10);
    }

    @Test
    public void testInsertNewWeather() {
        weatherService.insertNewWeather(sampleWeather);
        verify(weatherRepository, times(1)).save(sampleWeather);
    }

    @Test
    public void testGetAll() {
        List<Weather> expectedList = List.of(sampleWeather);
        when(weatherRepository.findAll()).thenReturn(expectedList);

        List<Weather> result = weatherService.getAll();
        assertEquals(expectedList, result);
    }

    @Test
    public void testGetById_Found() {
        when(weatherRepository.findById(1)).thenReturn(sampleWeather);
        Weather result = weatherService.getById(1);
        assertEquals(sampleWeather, result);
    }

    @Test
    public void testGetById_NotFound() {
        when(weatherRepository.findById(2)).thenReturn(null);
        assertThrows(NoSuchElementException.class, () -> weatherService.getById(2));
    }

    @Test
    public void testUpdateById() {
        Weather updated = new Weather();
        updated.setAtmophericPressure(1000.0);
        updated.setDate(LocalDateTime.now());
        updated.setDirWind(180);
        updated.setHumidity(80);
        updated.setProbaRain(50);
        updated.setTemperature(19.0);
        updated.setType(WeatherType.CLOUDY);
        updated.setWind(5);

        when(weatherRepository.findById(1)).thenReturn(sampleWeather);

        Weather result = weatherService.updateById(1, updated);

        assertEquals(updated.getTemperature(), result.getTemperature());
        verify(weatherRepository, times(1)).save(sampleWeather);
    }

    @Test
    public void testGetByMunicipalityId() {
        when(weatherRepository.findByMunicipalityId(10)).thenReturn(sampleWeather);
        Weather result = weatherService.getByMunicipalityId(10);
        assertEquals(sampleWeather, result);
    }

    @Test
    public void testGetByMunicipalityName_Found() {
        Weather olderWeather = new Weather();
        olderWeather.setDate(LocalDateTime.now().minusDays(1));
        Weather newerWeather = new Weather();
        newerWeather.setDate(LocalDateTime.now());

        when(weatherRepository.findByMunicipalityNameContaining("Paris"))
            .thenReturn(List.of(olderWeather, newerWeather));

        Weather result = weatherService.getByMunicipalityName("Paris");
        assertEquals(newerWeather.getDate(), result.getDate());
    }

    @Test
    public void testGetByMunicipalityName_NotFound() {
        when(weatherRepository.findByMunicipalityNameContaining("Nowhere"))
            .thenReturn(Collections.emptyList());

        assertThrows(NoSuchElementException.class, () -> weatherService.getByMunicipalityName("Nowhere"));
    }

    @Test
    public void testDeleteById() {
        when(weatherRepository.findById(1)).thenReturn(sampleWeather);
        weatherService.deleteById(1);
        verify(weatherRepository).delete(sampleWeather);
    }
}