package fr.lusuva.lusuvair.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.lusuva.lusuvair.entities.Municipality;
import fr.lusuva.lusuvair.entities.UserAccount;
import fr.lusuva.lusuvair.entities.Weather;

/**
 * Repository interface for managing {@link Weather} entities.
 */
public interface WeatherRepository extends JpaRepository<UserAccount, Integer>{
	
	/**
     * Finds a {@link Weather} entity by its id.
     * 
     * @param id the id of the Weather entity
     * @return the Weather entity with the specified id or null if none found
     */
	Weather findById(int id);
	
	Weather findByMunicipality(Municipality municipality);

	void save(Weather weather);
}
