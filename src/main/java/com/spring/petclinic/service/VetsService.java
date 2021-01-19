package com.spring.petclinic.service;

import com.spring.petclinic.domain.Vet;
import com.spring.petclinic.repository.VetsRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class VetsService {
    private final VetsRepository vetsRepository;

    @Autowired
    public VetsService(VetsRepository vetsRepository) {
        this.vetsRepository = vetsRepository;
    }

    /**
     * 전체 수의사 조회
     */
    public List<Vet> findVets() {
        return vetsRepository.findAll();
    }
}
