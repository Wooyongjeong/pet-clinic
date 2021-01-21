package com.spring.petclinic.repository;

import com.spring.petclinic.domain.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaOwnerRepository extends JpaRepository<Owner, Long>, OwnerRepository {
}
