package com.spring.petclinic.repository;

import com.spring.petclinic.domain.Visit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataJpaVisitRepository extends JpaRepository<Visit, Long>, VisitRepository {
}
