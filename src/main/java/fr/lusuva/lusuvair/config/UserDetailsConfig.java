package fr.lusuva.lusuvair.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;

import fr.lusuva.lusuvair.mapper.UserMapper;
import fr.lusuva.lusuvair.repositories.UserAccountRepository;

/**
 * Configuration that details UserDetails
 */
@Configuration
public class UserDetailsConfig {
    
    /**
     * UserAccount Repository
     */
    @Autowired
    private UserAccountRepository userAccountRepository;

    /**
     * Bean definying a UserDetailsService implementation
     * @return
     */
    @Bean
	UserDetailsService userDetailsService() {
		return username -> UserMapper.toUserDetails(userAccountRepository.findByEmail(username));
	}
}
