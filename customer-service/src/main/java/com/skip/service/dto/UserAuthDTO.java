package com.skip.service.dto;

/**
 * Represents the Store etity
 * @author Note-Chronos
 *
 */
public class UserAuthDTO {

	private final String email;
	
	private final String password;
	
	public UserAuthDTO(String email, String password) {
		this.email = email;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}
	
	
}
