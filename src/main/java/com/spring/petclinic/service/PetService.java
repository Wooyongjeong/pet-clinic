package com.spring.petclinic.service;

import com.spring.petclinic.controller.PetForm;
import com.spring.petclinic.domain.Owner;
import com.spring.petclinic.domain.Pet;
import com.spring.petclinic.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetService {
    private final PetRepository petRepository;

    @Autowired
    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }


    /*
    * 애완동물 등록
    * */
    public Long join(Pet pet, Owner owner) {
        pet.setOwner(owner);
        return petRepository.save(pet).getId();
    }

    /*
    * 특정 보호자에게 등록된 전체 애완동물 조회
    * */
    public List<Pet> findByOwnerId(Long ownerId) {
        return petRepository.findByOwnerId(ownerId);
    }

    /*
    * id로 애완동물 조회
    * */
    public Optional<Pet> findOne(Long id) {
        return petRepository.findById(id);
    }

    /*
    * 애완동물 update
    * */
    public Pet update(Long id, PetForm form) {
        Pet pet = findOne(id).get();
        pet.update(form);
        return petRepository.save(pet);
    }
}
