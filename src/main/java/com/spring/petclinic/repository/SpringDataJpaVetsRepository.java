package com.spring.petclinic.repository;

import com.spring.petclinic.domain.Vet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpringDataJpaVetsRepository extends JpaRepository<Vet, Long>, VetsRepository {
    @Override
    List<Vet> findAll();
}
