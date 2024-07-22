package fr.lusuva.lusuvair.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.lusuva.lusuvair.entities.Municipality;
import fr.lusuva.lusuvair.entities.Particle;
import fr.lusuva.lusuvair.entities.UserAccount;
import fr.lusuva.lusuvair.repositories.MunicipalityRepository;
import fr.lusuva.lusuvair.repositories.ParticleRepository;
import jakarta.annotation.PostConstruct;

@Service
public class MunicipalityService {

    @Autowired
    private MunicipalityRepository municipalityRepository;

    /**
     * Inserts a new Municipality entity in database.
     * This method uses the MunicipalityRepository to save the given Municipality entity.
     *
     * @param Municipality entity to be inserted
     */
    public void insertMunicipality(List<Municipality> municipality) {
    	municipalityRepository.saveAll(municipality);
    }
    
    public List<Municipality> getMunicipalities(){
    	return municipalityRepository.findAll();
    }
    
	@PostConstruct
	public void init() {
        List<Municipality> municipalities = new ArrayList<>();
        municipalities.add(new Municipality(44000, "Nantes", 320732));
        municipalities.add(new Municipality(49000, "Angers", 155786));
        municipalities.add(new Municipality(72000, "Le-Mans", 1451500));
        municipalities.add(new Municipality(44000, "Saint-Nazaire", 71887));
        municipalities.add(new Municipality(85000, "Roche-Sur-Yon", 55213));
        municipalities.add(new Municipality(49000, "Cholet", 54357));
//        municipalities.add(new Municipality(53000, "Laval", 49617));
        municipalities.add(new Municipality(44000, "rezé", 42993));
        insertMunicipality(municipalities);
	}
    
}
