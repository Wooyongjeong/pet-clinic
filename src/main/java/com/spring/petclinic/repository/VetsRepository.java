package com.spring.petclinic.repository;

import com.spring.petclinic.domain.Vet;

import java.util.List;

public interface VetsRepository {
    List<Vet> findAll();
}
