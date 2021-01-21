package com.spring.petclinic.repository;

import com.spring.petclinic.domain.Pet;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PetRepository {
    Pet save(Pet pet);
    Optional<Pet> findById(Long id);
    List<Pet> findByOwnerId(Long ownerId);
}
