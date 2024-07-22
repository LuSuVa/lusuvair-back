package fr.lusuva.lusuvair.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.lusuva.lusuvair.entities.AirQuality;

public interface AirQualityRepository extends JpaRepository<AirQuality, Integer> {
	void deleteByDate( String Date); 
}
