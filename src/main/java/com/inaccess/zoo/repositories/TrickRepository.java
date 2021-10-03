package com.inaccess.zoo.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inaccess.zoo.model.tricks.Trick;

public interface TrickRepository extends JpaRepository<Trick, UUID>{

}
