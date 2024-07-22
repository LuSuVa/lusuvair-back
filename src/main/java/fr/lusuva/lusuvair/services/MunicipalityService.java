package fr.lusuva.lusuvair.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.lusuva.lusuvair.entities.Municipality;
import fr.lusuva.lusuvair.repositories.MunicipalityRepository;
import jakarta.annotation.PostConstruct;

/**
 * Service class for managing {@code Municipality} entities.
 * 
 * This service provides methods to insert and retrieve Municipality entities
 * from the database. It also initializes a set of default municipalities
 * when the service is first created.
 */
@Service
public class MunicipalityService {

    @Autowired
    private MunicipalityRepository municipalityRepository;

    /**
     * Inserts a list of Municipality entities into the database.
     * This method uses the MunicipalityRepository to save all provided Municipality entities.
     *
     * @param municipalities the list of Municipality entities to be inserted
     */
    public void insertMunicipality(List<Municipality> municipalities) {
        municipalityRepository.saveAll(municipalities);
    }

    /**
     * Retrieves all Municipality entities from the database.
     * 
     * @return a list of all Municipality entities
     */
    public List<Municipality> getMunicipalities() {
        return municipalityRepository.findAll();
    }

    /**
     * Initializes the service with a predefined list of Municipality entities.
     * This method is called automatically after the service is constructed.
     */
    @PostConstruct
    public void init() {
        List<Municipality> municipalities = new ArrayList<>();
        municipalities.add(new Municipality(44000, "Nantes", 320732, 44109));
        municipalities.add(new Municipality(49000, "Angers", 155786, 49007));
        municipalities.add(new Municipality(72000, "Le-Mans", 1451500, 72181));
        municipalities.add(new Municipality(44000, "Saint-Nazaire", 71887, 44184));
        municipalities.add(new Municipality(85000, "Roche-Sur-Yon", 55213, 85191));
        municipalities.add(new Municipality(49000, "Cholet", 54357, 49099));
        municipalities.add(new Municipality(44000, "Rezé", 42993, 44143));
        insertMunicipality(municipalities);
    }
}
