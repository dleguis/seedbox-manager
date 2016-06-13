package net.dleguis.seedbox.service;

import java.util.Optional;

import net.dleguis.seedbox.common.dto.UserDto;

/**
 * The interface User service.
 */
public interface UserService {
	Optional<UserDto> getByUsername(String username);
}
