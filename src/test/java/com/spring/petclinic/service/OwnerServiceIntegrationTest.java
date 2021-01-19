package com.spring.petclinic.service;

import com.spring.petclinic.domain.Owner;
import com.spring.petclinic.repository.OwnerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class OwnerServiceIntegrationTest {
    @Autowired
    OwnerService ownerService;
    @Autowired
    OwnerRepository ownerRepository;

    @Test
    public void 회원가입() throws Exception {
        // Given
        Owner owner = new Owner();
        owner.setName("jeong");

        // When
        Long saveId = ownerService.join(owner);

        // Then
        Owner findOwner = ownerService.findOne(saveId).get();
        assertThat(owner.getName()).isEqualTo(findOwner.getName());
    }

    @Test
    public void 중복_회원_예외() throws Exception {
        // Given
        Owner owner1 = new Owner();
        owner1.setName("jeong");

        Owner owner2 = new Owner();
        owner2.setName("jeong");

        // When
        ownerService.join(owner1);
        IllegalStateException e = assertThrows(IllegalStateException.class,
                () -> ownerService.join(owner2));

        // Then
        assertThat(e.getMessage()).isEqualTo("이미 등록된 핸드폰 번호입니다.");
    }
}
