package com.spring.petclinic.service;

import com.spring.petclinic.controller.OwnerForm;
import com.spring.petclinic.domain.Owner;
import com.spring.petclinic.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

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
        ownerRepository.findByPhone(owner.getPhone())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 등록된 핸드폰 번호입니다.");
                });
    }

    /*
     * 회원 정보 수정
     * */
    public Long update(Long id, OwnerForm form) {
        Owner owner = findOne(id).get();
        owner.update(form);
        ownerRepository.save(owner);
        return owner.getId();
    }

    /*
     * 전체 보호자 조회
     * */
    public List<Owner> findOwners() {
        return ownerRepository.findAll();
    }

    /*
     * 핸드폰 번호로 보호자 조회
     * */
    public Long findByPhone(String phone) {
        Owner owner = ownerRepository.findByPhone(phone).get();
        return owner.getId();
    }

    public Optional<Owner> findOne(Long ownerId) {
        return ownerRepository.findById(ownerId);
    }
}
