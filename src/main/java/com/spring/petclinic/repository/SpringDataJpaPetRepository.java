package com.spring.petclinic.repository;

import com.spring.petclinic.domain.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataJpaPetRepository extends JpaRepository<Pet, Long>, PetRepository {
}
