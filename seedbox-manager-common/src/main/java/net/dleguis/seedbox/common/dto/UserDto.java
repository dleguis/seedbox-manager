package net.dleguis.seedbox.common.dto;

import lombok.Data;

@Data
public class UserDto {

	private String login;
	private String password;
	private String email;
	private String firstname;
	private String lastname;

}
