package fr.lusuva.lusuvair.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.lusuva.lusuvair.entities.Forum;

/**Repository interface for managing {@link Forum} entities.
 * 
 * @see Forum
 */
public interface ForumRepository extends JpaRepository<Forum, Integer> {

}
