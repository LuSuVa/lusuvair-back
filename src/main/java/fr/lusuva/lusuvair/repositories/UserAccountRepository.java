package fr.lusuva.lusuvair.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.lusuva.lusuvair.entities.UserAccount;

/**
 * Repository interface for {@link UserAccount} entities.
 * 
 * Provides methods to perform CRUD operations and custom queries on {@link UserAccount} entities.
 */
public interface UserAccountRepository extends JpaRepository<UserAccount, Integer> {

    /**
     * Finds a {@link UserAccount} by its email.
     * 
     * @param email the email of the user account
     * @return the {@link UserAccount} with the specified email, or {@code null} if none found
     */
    UserAccount findByEmail(String email);
}
