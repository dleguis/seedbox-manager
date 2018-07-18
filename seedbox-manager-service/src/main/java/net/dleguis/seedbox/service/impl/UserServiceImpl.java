package net.dleguis.seedbox.service.impl;

import java.util.Optional;

import net.dleguis.seedbox.common.dto.UserDto;
import net.dleguis.seedbox.domain.repository.UserRepository;
import net.dleguis.seedbox.service.UserService;
import net.dleguis.seedbox.service.mapper.UserMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The type User service.
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserMapper userMapper;

	@Override
	public Optional<UserDto> getByUsername(String username) {

		return userRepository.findByLogin(username).map(user -> Optional.ofNullable(userMapper.asUserDto(user))).orElse(null);

	}
}
