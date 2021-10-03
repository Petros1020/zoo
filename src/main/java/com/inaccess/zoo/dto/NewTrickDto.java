package com.inaccess.zoo.dto;

import java.util.UUID;

public class NewTrickDto {

	private final UUID id;
	private final String name;
	private final String newTrick;
	
	
	public NewTrickDto(UUID id, String name, String newTrick) {
		super();
		this.id = id;
		this.name = name;
		this.newTrick = newTrick;
	}
	
	
	public UUID getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getNewTrick() {
		return newTrick;
	}
	
	
	
}
