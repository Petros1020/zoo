package com.inaccess.zoo.converters;

import java.util.ArrayList;
import java.util.List;

import com.inaccess.zoo.dto.AnimalDto;
import com.inaccess.zoo.model.animals.Animal;

public class AnimalConverter {

	private AnimalConverter() {
	}

	public static AnimalDto convertAnimalToAnimalDto(Animal animal) {
		List<String> tricksDto = new ArrayList<>();

		animal.getTricks().forEach(trick -> {
			tricksDto.add(trick.getName());
		});

		return new AnimalDto(animal.getId(), animal.getName(), animal.getSpecies(), tricksDto);
	}

}
