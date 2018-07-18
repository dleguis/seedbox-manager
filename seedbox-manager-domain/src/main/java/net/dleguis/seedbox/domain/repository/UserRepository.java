package net.dleguis.seedbox.domain.repository;

import java.util.Optional;

import net.dleguis.seedbox.domain.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The class UserRepository.
 *
 * @author administrateur
 * @since 0.0.1
 */
public interface UserRepository extends JpaRepository<User, Integer> {
	Optional<User> findByLogin(String login);
}
