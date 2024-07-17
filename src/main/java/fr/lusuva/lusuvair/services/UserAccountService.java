package fr.lusuva.lusuvair.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import fr.lusuva.lusuvair.dtos.UserRegisterDto;
import fr.lusuva.lusuvair.entities.UserAccount;
import fr.lusuva.lusuvair.repositories.UserAccountRepository;
import jakarta.annotation.PostConstruct;

/**
 * Service of UserAccount
 */
@Service
public class UserAccountService {
	/**
	 * UserAccount repository
	 */
	@Autowired
	UserAccountRepository userAccountRepository;

	/**
	 * Password encoder
	 */
	@Autowired
	PasswordEncoder passwordEncoder;

	/**
	 * Initialize 2 users in database after construct
	 */
	@PostConstruct
	public void init() {
		create(new UserAccount("Lusuva", "Lusuva", "admin5", passwordEncoder.encode("admin"), "ROLE_ADMIN"));
		create(new UserAccount("user", "user", "user", passwordEncoder.encode("user"), "ROLE_USER"));
	}

	/**
	 * Create a User
	 * 
	 * @param user
	 */
	public void create(UserAccount user) {
		userAccountRepository.save(user);
	}

	/**
	 * Register an user by a UserRegisterDto
	 * 
	 * @param userRegisterDto Dto
	 * @throws IllegalArgumentException if an user is already using this email
	 */
	public void register(UserRegisterDto userRegisterDto) throws IllegalArgumentException {
		if (userAccountRepository.findByEmail(userRegisterDto.getEmail()) != null) {
			throw new IllegalArgumentException("Email is already used");
		}

		UserAccount userAccount = new UserAccount(
				userRegisterDto.getFirstName(),
				userRegisterDto.getLastName(),
				userRegisterDto.getEmail(),
				passwordEncoder.encode(userRegisterDto.getPassword()),
				"ROLE_USER");

		create(userAccount);
	}
}
