package fr.lusuva.lusuvair.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.lusuva.lusuvair.entities.Particle;

public interface ParticleRepository extends JpaRepository<Particle, Integer> {

}
