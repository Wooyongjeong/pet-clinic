package com.spring.petclinic.service;

import com.spring.petclinic.domain.Vets;
import com.spring.petclinic.repository.VetsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List<Vets> findVets() {
        return vetsRepository.findAll();
    }
}
