package com.inaccess.zoo.repositories;

import java.util.UUID;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.inaccess.zoo.model.animals.Animal;

public interface AnimalRepository extends PagingAndSortingRepository<Animal, UUID> {

}
