package com.spring.petclinic.service;

import com.spring.petclinic.controller.VisitForm;
import com.spring.petclinic.domain.Owner;
import com.spring.petclinic.domain.Pet;
import com.spring.petclinic.domain.Visit;
import com.spring.petclinic.repository.OwnerRepository;
import com.spring.petclinic.repository.PetRepository;
import com.spring.petclinic.repository.VisitRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class VisitServiceTest {
    @Autowired
    VisitService visitService;
    @Autowired
    VisitRepository visitRepository;
    @Autowired
    PetService petService;
    @Autowired
    PetRepository petRepository;
    @Autowired
    OwnerService ownerService;
    @Autowired
    OwnerRepository ownerRepository;

    @Test
    public void 방문정보등록() {
        // Given
        Owner owner = new Owner();
        owner.setName("ownerName");
        Pet pet = new Pet();
        pet.setName("cheese");
        pet.setType("고양이");
        pet.setBirthDate("2021-01-29");
        Long ownerId = ownerService.join(owner);
        Long petId = petService.join(pet, owner);
        // When
        Visit visit = new Visit();
        visit.setVisitDate("2021-01-29");
        visit.setDescription("예방접종");
        Long visitId = visitService.join(visit, pet);
        // Then
        Visit findVisit = visitService.findOne(visitId).get();
        assertThat(visit.getDescription()).isEqualTo(findVisit.getDescription());
    }

    @Test
    public void 방문정보수정() {
        // Given
        Owner owner = new Owner();
        owner.setName("ownerName");
        Pet pet = new Pet();
        pet.setName("cheese");
        pet.setType("고양이");
        pet.setBirthDate("2021-01-29");
        Long ownerId = ownerService.join(owner);
        Long petId = petService.join(pet, owner);
        Visit visit = new Visit();
        visit.setVisitDate("2021-01-29");
        visit.setDescription("예방접종");
        Long visitId = visitService.join(visit, pet);
        // When
        VisitForm form = new VisitForm();
        form.setVisitDate("2021-01-29");
        form.setDescription("혈액검사");
        Visit updateVisit = visitService.update(visitId, form);
        // Then
        assertThat(updateVisit.getDescription()).isEqualTo("혈액검사");
    }
}
