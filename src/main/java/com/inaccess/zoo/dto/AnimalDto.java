package com.inaccess.zoo.dto;

import java.util.List;
import java.util.UUID;

public class AnimalDto {

	private final UUID id;
	private final String name;
	private final String species;
	private final List<String> tricks;
	
	
	public AnimalDto(UUID id, String name, String species, List<String> tricks) {
		super();
		this.id = id;
		this.name = name;
		this.species = species;
		this.tricks = tricks;
	}

	public UUID getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getSpecies() {
		return species;
	}

	public List<String> getTricks() {
		return tricks;
	}
	
	
}
