package fr.lusuva.lusuvair.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Security Config
 */
@Configuration
@EnableMethodSecurity
public class SecurityConfig {

	/**
	 * Autowired JwtAuthenticationFilter
	 */
	@Autowired
	private JwtAuthenticationFilter jwtAuthenticationFilter;

	/**
	 * Autowired UserDetailsService
	 */
	@Autowired
	private UserDetailsService userDetailsService;

	/**
	 * Bean defining a password encoder (BCrypt)
	 * 
	 * @return PasswordEncoder
	 */
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	/**
	 * Bean defining a authentication manager
	 * 
	 * @return AuthenticationManager
	 */
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
		return configuration.getAuthenticationManager();
	}

	/**
	 * Bean defining a authentication provider
	 * 
	 * @return AuthenticationProvider
	 */
	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService);
		authProvider.setPasswordEncoder(passwordEncoder());

		return authProvider;
	}

	/**
	 * Bean defining a Security Filter Chain
	 * For now, all routes are permit
	 * 
	 * @param httpSecu HttpSecurity
	 * @return SecurityFilterChain
	 * @throws Exception
	 */
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecu) throws Exception {
		httpSecu.csrf(csrf -> csrf.disable());

		httpSecu.authorizeHttpRequests(request -> request
				.requestMatchers("/**").permitAll()
		// .requestMatchers("/logout").authenticated()
		// .requestMatchers("/townList").authenticated()
		// .requestMatchers("/deleteTown/**").hasRole("ADMIN")
		// .anyRequest().denyAll()
		)
				.httpBasic(Customizer.withDefaults())
				.formLogin(Customizer.withDefaults())
				.sessionManagement(manager -> manager.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.authenticationProvider(authenticationProvider()).addFilterBefore(
						jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

		return httpSecu.build();
	}
}
