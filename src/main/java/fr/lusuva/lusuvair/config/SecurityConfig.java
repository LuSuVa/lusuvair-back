package fr.lusuva.lusuvair.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import fr.lusuva.lusuvair.mapper.UserMapper;
import fr.lusuva.lusuvair.repositories.UserAccountRepository;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

	@Bean
	PasswordEncoder passwordEncoder () {
		return new BCryptPasswordEncoder();
	}
	
	@Bean 
	UserDetailsService userDetailsService(UserAccountRepository userRepository) {
		return username -> UserMapper.toUserDetails(userRepository.findByEmail(username));
	}
	
//	@Bean
//	SecurityFilterChain securityFilterChain(HttpSecurity httpSecu) throws Exception {
//		httpSecu.authorizeHttpRequests(request -> request
//				.requestMatchers("/","/login").permitAll()
//				.requestMatchers("/logout").authenticated()
//				.requestMatchers("/townList").authenticated()
//				.requestMatchers("/deleteTown/**").hasRole("ADMIN")
//				.anyRequest().denyAll()
//				)
//		.httpBasic(Customizer.withDefaults()).formLogin(Customizer.withDefaults());
//		return httpSecu.build();
//	}
}
