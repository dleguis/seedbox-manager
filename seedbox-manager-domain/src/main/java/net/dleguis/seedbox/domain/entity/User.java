package net.dleguis.seedbox.domain.entity;

import javax.persistence.Entity;

import lombok.Data;

@Entity
@Data
public class User {

	private String login;
	private String password;
	private String email;
	private String firstname;
	private String lastname;
}
