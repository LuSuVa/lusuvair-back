package fr.lusuva.lusuvair.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import fr.lusuva.lusuvair.dtos.auth.JwtAuthenticationResponse;
import fr.lusuva.lusuvair.dtos.auth.UserLoginDto;
import fr.lusuva.lusuvair.dtos.auth.UserRegisterDto;
import fr.lusuva.lusuvair.entities.UserAccount;
import fr.lusuva.lusuvair.mappers.UserMapper;
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
	 * JwtService
	 */
	@Autowired
	private JwtService jwtService;

	/**
	 * AuthenticationManager
	 */
	@Autowired
	private AuthenticationManager authenticationManager;

	/**
	 * Initialize 2 users in database after construct
	 */
	@PostConstruct
	public void init() {
		create(new UserAccount("Dobole", "Lusuva", "admin5@test.com", passwordEncoder.encode("admin"), "ROLE_ADMIN",
				"ROLE_USER"));
		create(new UserAccount("user", "user", "user@test.com", passwordEncoder.encode("user"), "ROLE_USER"));
		create(new UserAccount("user", "user", "user2@test.com", passwordEncoder.encode("user"), "ROLE_USER"));
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
	public JwtAuthenticationResponse register(UserRegisterDto userRegisterDto) throws IllegalArgumentException {
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

		var jwt = jwtService.generateToken(userAccount.getEmail());
		List<String> roles = userAccount.getAuthorities().stream().map(authority -> authority.getAuthority()).toList();
		
		return new JwtAuthenticationResponse(jwt, roles);
	}

	/**
	 * Login an user if their information are correct
	 * 
	 * @param userLoginDto UserLoginDto
	 * @return JwtAuthenticationResponse
	 * @throws IllegalArgumentException if information not correct
	 */
	public JwtAuthenticationResponse login(UserLoginDto userLoginDto) throws IllegalArgumentException {
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(userLoginDto.getEmail(), userLoginDto.getPassword()));

		var user = userAccountRepository.findByEmail(userLoginDto.getEmail());

		if (user == null) {
			throw new IllegalArgumentException("Invalid username/email or password");
		}

		String jwt = jwtService.generateToken(UserMapper.toUserDetails(user).getUsername());
		List<String> roles = user.getAuthorities().stream().map(authority -> authority.getAuthority()).toList();

		return new JwtAuthenticationResponse(jwt, roles);
	}
}
