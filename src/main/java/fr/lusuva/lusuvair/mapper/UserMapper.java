package fr.lusuva.lusuvair.mapper;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import fr.lusuva.lusuvair.entities.UserAccount;

public class UserMapper {
	public static UserDetails toUserDetails(UserAccount userAccount) {
		return User.builder()
				.username(userAccount.getEmail())
				.password(userAccount.getPassword())
				.authorities(userAccount.getAuthorities())
				.build();
	}
}
