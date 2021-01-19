package com.spring.petclinic.repository;

import com.spring.petclinic.domain.Pet;

import java.util.List;
import java.util.Optional;

public interface PetRepository {
    Pet save(Pet pet);
    Optional<Pet> findById(Long id);
    List<Pet> findByOwnerId(Long ownerId);
}
