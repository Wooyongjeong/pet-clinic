package com.spring.petclinic.service;

import com.spring.petclinic.domain.Owner;
import com.spring.petclinic.domain.Pet;
import com.spring.petclinic.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {
    private final PetRepository petRepository;

    @Autowired
    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    public Long join(Pet pet, Owner owner) {
        pet.setOwner(owner);
        return petRepository.save(pet).getId();
    }

    public List<Pet> findByOwnerId(Long ownerId) {
        return petRepository.findByOwnerId(ownerId);
    }
}
