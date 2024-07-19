package fr.lusuva.lusuvair.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.lusuva.lusuvair.entities.Forum;

/**
 * Forum Repository
 */
public interface ForumRepository extends JpaRepository<Forum, Integer> {

}
