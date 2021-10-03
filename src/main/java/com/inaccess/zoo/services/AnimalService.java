package com.inaccess.zoo.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.inaccess.zoo.converters.AnimalConverter;
import com.inaccess.zoo.dto.AnimalDto;
import com.inaccess.zoo.dto.NewTrickDto;
import com.inaccess.zoo.model.animals.Animal;
import com.inaccess.zoo.model.tricks.Trick;
import com.inaccess.zoo.repositories.AnimalRepository;
import com.inaccess.zoo.repositories.TrickRepository;

@Service
public class AnimalService {

	private AnimalRepository animalRepository;

	private TrickRepository trickRepository;

	public AnimalService(AnimalRepository animalRepository, TrickRepository trickRepository) {
		super();
		this.animalRepository = animalRepository;
		this.trickRepository = trickRepository;
	}

	public Page<AnimalDto> getAllAnimalsPaginated(Pageable pageable) {
		return animalRepository.findAll(pageable).map(AnimalConverter::convertAnimalToAnimalDto);
	}

	public Animal findById(UUID id) {
		return animalRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
	}

	@Transactional
	public NewTrickDto addRandomTrickToAnimal(UUID animalId) {
		Animal animal = this.findById(animalId);
		List<Trick> tricks = trickRepository.findAll();

		Optional<Trick> newTrickOptional = animal.newTrickToLearn(tricks);

		if (newTrickOptional.isPresent()) {
			animalRepository.save(animal);
			return new NewTrickDto(animal.getId(), animal.getName(), newTrickOptional.get().getName());

		} else {
			return new NewTrickDto(animal.getId(), animal.getName(), "None");

		}
	}

}
