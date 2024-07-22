package fr.lusuva.lusuvair.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import fr.lusuva.lusuvair.entities.Municipality;

public interface MunicipalityRepository extends JpaRepository<Municipality, Integer> {

}
