package com.inaccess.zoo.controllers;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.inaccess.zoo.converters.TrickConverter;
import com.inaccess.zoo.dto.AnimalDto;
import com.inaccess.zoo.dto.NewTrickDto;
import com.inaccess.zoo.dto.TrickDto;
import com.inaccess.zoo.services.AnimalService;

@RestController
@RequestMapping("/animals")
public class AnimalController {

	private AnimalService animalService;

	public AnimalController(AnimalService animalService) {
		this.animalService = animalService;
	}

	@GetMapping("/all")
	public Page<AnimalDto> getAll(@PageableDefault(page = 0, size = 100) Pageable pageable) {
		return animalService.getAllAnimalsPaginated(pageable);
	}

	@GetMapping("/all/bySpecies")
	public Page<AnimalDto> getAllGrouped(@PageableDefault(page = 0, size = 100, sort = "species") Pageable pageable) {
		return animalService.getAllAnimalsPaginated(pageable);
	}

	@GetMapping("/{animalId}/doTrick")
	public TrickDto geTrick(@PathVariable("animalId") UUID animalId) {
		return TrickConverter.getTrickDtoFromAnimal(animalService.findById(animalId));
	}

	@PostMapping("/{animalId}/learnTrick")
	@ResponseStatus(HttpStatus.CREATED)
	public NewTrickDto learnTrick(@PathVariable("animalId") UUID animalId) {
		return animalService.addRandomTrickToAnimal(animalId);
	}

}
