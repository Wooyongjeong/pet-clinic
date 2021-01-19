package com.spring.petclinic.service;

import com.spring.petclinic.domain.Vet;
import com.spring.petclinic.repository.VetRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class VetService {
    private final VetRepository vetRepository;

    @Autowired
    public VetService(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }

    /**
     * 전체 수의사 조회
     */
    public List<Vet> findVets() {
        return vetRepository.findAll();
    }
}
