package com.spring.petclinic.repository;

import com.spring.petclinic.domain.Vets;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface VetsRepository {
    List<Vets> findAll();
}
