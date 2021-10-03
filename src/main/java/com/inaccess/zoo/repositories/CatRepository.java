package com.inaccess.zoo.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inaccess.zoo.model.animals.Cat;

public interface CatRepository extends JpaRepository<Cat, UUID>{

}
