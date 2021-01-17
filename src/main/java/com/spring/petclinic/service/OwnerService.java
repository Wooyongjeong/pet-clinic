package com.spring.petclinic.service;

import com.spring.petclinic.domain.Owner;
import com.spring.petclinic.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public class OwnerService {
    private final OwnerRepository ownerRepository;

    @Autowired
    public OwnerService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    /*
    * 회원 가입
    * */
    public Long join(Owner owner) {
        validateDuplicateOwner(owner); // 중복 보호자 검증
        ownerRepository.save(owner);
        return owner.getId();
    }

    private void validateDuplicateOwner(Owner owner) {
        ownerRepository.findByName(owner.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 보호자 이름입니다.");
                });
    }

    /*
     * 전체 보호자 조회
     * */
    public List<Owner> findOwners() {
        return ownerRepository.findAll();
    }

    public Optional<Owner> findOne(Long ownerId) {
        return ownerRepository.findById(ownerId);
    }
}
