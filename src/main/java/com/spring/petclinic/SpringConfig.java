package com.spring.petclinic;

import com.spring.petclinic.repository.OwnerRepository;
import com.spring.petclinic.repository.VetsRepository;
import com.spring.petclinic.service.OwnerService;
import com.spring.petclinic.service.VetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SpringConfig {
    private final OwnerRepository ownerRepository;
    private final VetsRepository vetsRepository;

    @Autowired
    public SpringConfig(OwnerRepository ownerRepository, VetsRepository vetsRepository) {
        this.ownerRepository = ownerRepository;
        this.vetsRepository = vetsRepository;
    }

    @Bean
    public OwnerService ownerService() {
        return new OwnerService(ownerRepository);
    }

    @Bean
    public VetsService vetsService() {
        return new VetsService(vetsRepository);
    }
}
