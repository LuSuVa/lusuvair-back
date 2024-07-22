package fr.lusuva.lusuvair.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.lusuva.lusuvair.entities.Municipality;
import fr.lusuva.lusuvair.entities.Particle;
import fr.lusuva.lusuvair.repositories.MunicipalityRepository;
import fr.lusuva.lusuvair.repositories.ParticleRepository;

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
    
}
