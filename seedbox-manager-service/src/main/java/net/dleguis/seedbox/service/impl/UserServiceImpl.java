package net.dleguis.seedbox.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import net.dleguis.seedbox.common.dto.UserDto;
import net.dleguis.seedbox.service.UserService;

/**
 * The type User service.
 */
@Service
public class UserServiceImpl implements UserService {

	@Override
	public Optional<UserDto> getByUsername(String username) {
		return null;
	}
}
