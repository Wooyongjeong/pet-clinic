package com.spring.petclinic.repository;

import com.spring.petclinic.domain.Owner;

import java.util.List;
import java.util.Optional;

public interface OwnerRepository {
    Owner save(Owner owner);
    Optional<Owner> findById(Long id);
    Optional<Owner> findByPhone(String phone);
    List<Owner> findAll();
}
