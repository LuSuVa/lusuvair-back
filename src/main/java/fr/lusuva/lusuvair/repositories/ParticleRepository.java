package fr.lusuva.lusuvair.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.lusuva.lusuvair.entities.Particle;

/**
 * Repository interface for {@link Particle} entities.
 * 
 * Provides methods to perform CRUD operations on {@link Particle} entities,
 * including a method to delete particles by name and quantity.
 */
public interface ParticleRepository extends JpaRepository<Particle, Integer> {

    /**
     * Deletes a {@link Particle} entity by its name and quantity.
     * 
     * @param name the name of the particle
     * @param quantity the quantity of the particle
     */
    void deleteByNameAndQuantity(String name, Double quantity);
}
