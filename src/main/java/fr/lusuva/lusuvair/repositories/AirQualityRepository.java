package fr.lusuva.lusuvair.repositories;

import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import fr.lusuva.lusuvair.entities.AirQuality;
import fr.lusuva.lusuvair.entities.Municipality;
import fr.lusuva.lusuvair.entities.Particle;

public interface AirQualityRepository extends JpaRepository<AirQuality, Integer> {
	void deleteByDate( String Date); 
}
