package fr.lusuva.lusuvair.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.lusuva.lusuvair.entities.Particle;
import fr.lusuva.lusuvair.repositories.ParticleRepository;
import jakarta.transaction.Transactional;

/**
 * Service class for managing {@code Particle} entities.
 * 
 * This service provides methods to insert and delete Particle entities
 * from the database.
 */
@Service
public class ParticleService {

    @Autowired
    private ParticleRepository particleRepository;

    /**
     * Inserts a new Particle entity into the database.
     * This method uses the ParticleRepository to save the provided Particle entity.
     *
     * @param particle the Particle entity to be inserted
     */
    public void insertParticle(Particle particle) {
        particleRepository.save(particle);
    }

    /**
     * Deletes a Particle entity from the database based on its name and quantity.
     * This method uses the ParticleRepository to remove the Particle entity that matches
     * the given name and quantity.
     *
     * @param name the name of the Particle entity to be deleted
     * @param quantity the quantity of the Particle entity to be deleted
     */
    @Transactional
    public void deleteByNameAndQuantity(String name, Double quantity) {
        particleRepository.deleteByNameAndQuantity(name, quantity);
    }
}
