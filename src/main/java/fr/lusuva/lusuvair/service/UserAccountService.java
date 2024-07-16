package fr.lusuva.lusuvair.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import fr.lusuva.lusuvair.entities.UserAccount;
import fr.lusuva.lusuvair.repositories.UserAccountRepository;
import jakarta.annotation.PostConstruct;

@Service
public class UserAccountService {
	@Autowired
	UserAccountRepository userAccountRepository;
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@PostConstruct
	public void init() {
		create(new UserAccount("Lusuva","Lusuva","admin5",passwordEncoder.encode("admin"),"ROLE_ADMIN"));
		create(new UserAccount("user","user","user",passwordEncoder.encode("user"),"ROLE_USER"));
	}
	
	public void create(UserAccount user) {
		userAccountRepository.save(user);
	}
}
