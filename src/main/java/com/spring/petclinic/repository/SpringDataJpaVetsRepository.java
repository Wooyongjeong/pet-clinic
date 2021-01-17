package com.spring.petclinic.repository;

import com.spring.petclinic.domain.Vets;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpringDataJpaVetsRepository extends JpaRepository<Vets, Long>, VetsRepository {
    @Override
    List<Vets> findAll();
}
