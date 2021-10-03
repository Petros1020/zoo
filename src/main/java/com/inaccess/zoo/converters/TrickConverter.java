package com.inaccess.zoo.converters;

import com.inaccess.zoo.dto.TrickDto;
import com.inaccess.zoo.model.animals.Animal;

public class TrickConverter {
	
	private TrickConverter() {}
	
	public static TrickDto getTrickDtoFromAnimal (Animal animal) {
		return new TrickDto(animal.doTrick());
	}
}
