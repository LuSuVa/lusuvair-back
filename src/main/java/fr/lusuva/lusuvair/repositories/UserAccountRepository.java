package fr.lusuva.lusuvair.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.lusuva.lusuvair.UserAccount;

public interface UserAccountRepository extends JpaRepository<UserAccount, Integer> {

		UserAccount findByEmail(String email);
}
