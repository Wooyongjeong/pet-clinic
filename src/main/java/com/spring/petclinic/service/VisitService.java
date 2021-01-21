package com.spring.petclinic.service;

import com.spring.petclinic.domain.Pet;
import com.spring.petclinic.domain.Visit;
import com.spring.petclinic.repository.VisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisitService {
    private final VisitRepository visitRepository;

    @Autowired
    public VisitService(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    /*
    * 방문 정보 등록
    * */
    public Long join(Visit visit, Pet pet) {
        visit.setPet(pet);
        return visitRepository.save(visit).getId();
    }

    /*
    * 애완동물 id로 찾기
    * */
    public List<Visit> findByPetId(Long id) {
        return visitRepository.findByPetId(id);
    }
}
