package com.spring.petclinic;

import com.spring.petclinic.repository.OwnerRepository;
import com.spring.petclinic.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SpringConfig {
    private final OwnerRepository ownerRepository;

    @Autowired
    public SpringConfig(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Bean
    public OwnerService ownerService() {
        return new OwnerService(ownerRepository);
    }
}
