package com.spring.petclinic.service;

import com.spring.petclinic.controller.PetForm;
import com.spring.petclinic.domain.Owner;
import com.spring.petclinic.domain.Pet;
import com.spring.petclinic.repository.OwnerRepository;
import com.spring.petclinic.repository.PetRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class PetServiceTest {
    @Autowired
    PetService petService;
    @Autowired
    PetRepository petRepository;
    @Autowired
    OwnerService ownerService;
    @Autowired
    OwnerRepository ownerRepository;

    @Test
    public void 애완동물등록() {
        // Given
        Owner owner = new Owner();
        owner.setName("ownerName");
        Pet pet = new Pet();
        pet.setName("cheese");
        // When
        Long petId = petService.join(pet, owner);
        // Then
        Pet findPet = petService.findOne(petId).get();
        assertThat(pet.getName()).isEqualTo(findPet.getName());
    }
    
    @Test
    public void 애완동물프로필수정() {
        // Given
        Owner owner = new Owner();
        owner.setName("ownerName");
        Pet pet = new Pet();
        pet.setName("cheese");
        // When
        Long joinId = petService.join(pet, owner);
        PetForm form = new PetForm();
        form.setName("cheese2");
        form.setBirthDate("2020-02-02");
        form.setType("고양이");
        Pet updatePet = petService.update(joinId, form);
        // Then
        assertThat(form.getName()).isEqualTo(updatePet.getName());
    }

    @Test
    public void 보호자아이디로애완동물조회() {
        // Given
        Owner owner = new Owner();
        owner.setName("ownerName");
        Long ownerId = ownerService.join(owner);

        Pet pet1 = new Pet();
        pet1.setName("petName1");
        Pet pet2 = new Pet();
        pet2.setName("petName2");

        List<Pet> pets = new ArrayList<>();
        pets.add(pet1);
        pets.add(pet2);
        // When
        Long joinId1 = petService.join(pet1, owner);
        Long joinId2 = petService.join(pet2, owner);
        List<Pet> byOwnerId = petService.findByOwnerId(ownerId);
        // Then
        assertThat(pets).isEqualTo(byOwnerId);
    }
}
