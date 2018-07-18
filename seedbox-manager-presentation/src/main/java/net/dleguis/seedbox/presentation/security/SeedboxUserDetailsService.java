package net.dleguis.seedbox.presentation.security;

import java.util.HashSet;

import net.dleguis.seedbox.common.dto.UserDto;
import net.dleguis.seedbox.presentation.security.dto.CurrentUser;
import net.dleguis.seedbox.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SeedboxUserDetailsService implements UserDetailsService {

	@Autowired
	private UserService userService;

	@Override
	public CurrentUser loadUserByUsername(String username) {

		UserDto user = userService.getByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException(String.format("User with email=%s was not found", username)));

		CurrentUser currentUser = new CurrentUser(user.getLogin(), user.getPassword(), new HashSet<>());

		if (user.getFirstname() != null) {
			currentUser.setDisplayName(user.getFirstname());
		} else {
			currentUser.setDisplayName(user.getLogin());
		}

		return currentUser;
	}
}
