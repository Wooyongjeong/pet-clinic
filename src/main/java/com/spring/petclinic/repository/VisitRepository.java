package com.spring.petclinic.repository;

import com.spring.petclinic.domain.Visit;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VisitRepository {
    Visit save(Visit visit);
    Optional<Visit> findById(Long id);
    List<Visit> findByPetId(Long id);
}
