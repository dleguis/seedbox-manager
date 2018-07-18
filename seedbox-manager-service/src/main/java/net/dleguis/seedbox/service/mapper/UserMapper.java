package net.dleguis.seedbox.service.mapper;

import net.dleguis.seedbox.common.dto.UserDto;
import net.dleguis.seedbox.domain.entity.User;
import fr.xebia.extras.selma.IoC;
import fr.xebia.extras.selma.Mapper;

/**
 * The class UserMapper.
 *
 * @author administrateur
 * @since 0.0.1
 */
@Mapper(withIoC = IoC.SPRING)
public interface UserMapper {

	UserDto asUserDto(User user);

	User asUser(UserDto userDto);

}
