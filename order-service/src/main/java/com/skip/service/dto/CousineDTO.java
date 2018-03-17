package com.skip.service.dto;

/**
 * Represents the Store etity
 * @author Note-Chronos
 *
 */
public class CousineDTO {

	private final Long id;
	
	private final String name;
	
	public CousineDTO(Long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	
}
