package com.spring.petclinic.controller;

import com.spring.petclinic.domain.Vet;
import com.spring.petclinic.service.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class VetsController {
    private VetService vetService;

    @Autowired
    public VetsController(VetService vetService) {
        this.vetService = vetService;
    }

    @GetMapping("/vets")
    public String vets(Model model) {
        List<Vet> vets = vetService.findVets();
        model.addAttribute("currentPage", "vets");
        model.addAttribute("vetsList", vets);
        return "vets/vetList";
    }
}
