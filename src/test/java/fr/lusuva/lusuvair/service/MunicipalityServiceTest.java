package fr.lusuva.lusuvair.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import fr.lusuva.lusuvair.entities.Municipality;
import fr.lusuva.lusuvair.repositories.MunicipalityRepository;
import fr.lusuva.lusuvair.services.MunicipalityService;

public class MunicipalityServiceTest {


    @Mock
    private MunicipalityRepository municipalityRepository;

    @InjectMocks
    private MunicipalityService municipalityService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testInsertMunicipality() {
        Municipality municipality1 = new Municipality(44000, "Nantes", 320732,44109);
        Municipality municipality2 = new Municipality(49000, "Angers", 155786,49007);
        List<Municipality> municipalities = Arrays.asList(municipality1, municipality2);

        municipalityService.insertMunicipality(municipalities);

        verify(municipalityRepository, times(1)).saveAll(municipalities);
    }
    
    @Test
    public void testGetMunicipalities() {
        Municipality municipality1 = new Municipality(44000, "Nantes", 320732,44109);
        Municipality municipality2 = new Municipality(49000, "Angers", 155786,49007);
        List<Municipality> municipalities = Arrays.asList(municipality1, municipality2);

        when(municipalityRepository.findAll()).thenReturn(municipalities);

        List<Municipality> result = municipalityService.getMunicipalities();

        assertEquals(municipalities, result);
        verify(municipalityRepository, times(1)).findAll();
    }
    
}
