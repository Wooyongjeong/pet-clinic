package com.spring.petclinic;

import com.spring.petclinic.repository.OwnerRepository;
import com.spring.petclinic.repository.VetRepository;
import com.spring.petclinic.service.OwnerService;
import com.spring.petclinic.service.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SpringConfig {
    private final OwnerRepository ownerRepository;
    private final VetRepository vetRepository;

    @Autowired
    public SpringConfig(OwnerRepository ownerRepository, VetRepository vetRepository) {
        this.ownerRepository = ownerRepository;
        this.vetRepository = vetRepository;
    }

    @Bean
    public OwnerService ownerService() {
        return new OwnerService(ownerRepository);
    }

    @Bean
    public VetService vetsService() {
        return new VetService(vetRepository);
    }
}
