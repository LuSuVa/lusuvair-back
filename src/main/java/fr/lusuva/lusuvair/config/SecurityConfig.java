package fr.lusuva.lusuvair.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

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
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity httpSecu) throws Exception {
		httpSecu.csrf(csrf -> csrf.disable());

		httpSecu.authorizeHttpRequests(request -> request
				.requestMatchers("/**").permitAll()
				// .requestMatchers("/logout").authenticated()
				// .requestMatchers("/townList").authenticated()
				// .requestMatchers("/deleteTown/**").hasRole("ADMIN")
				// .anyRequest().denyAll()
				)
		.httpBasic(Customizer.withDefaults())
		.formLogin(Customizer.withDefaults());
		return httpSecu.build();
	}
}
