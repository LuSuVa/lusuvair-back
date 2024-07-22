package fr.lusuva.lusuvair.services;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import fr.lusuva.lusuvair.entities.Particle;
import fr.lusuva.lusuvair.repositories.ParticleRepository;
import jakarta.transaction.Transactional;

@Service
public class ParticleService {

    @Autowired
    private ParticleRepository particleRepository;

    /**
     * Inserts a new Particle entity in database.
     * This method uses the ParticleRepository to save the given Particle entity.
     *
     * @param particle The Particle entity to be inserted
     */
    public void insertParticle(Particle particle) {
        particleRepository.save(particle);
    }
    
    @Transactional
    public void deleteByNameAndQuantity(String name, Double quantity) {
    	particleRepository.deleteByNameAndQuantity(name,quantity);
    }
}
