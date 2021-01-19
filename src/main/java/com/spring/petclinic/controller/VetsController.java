package com.spring.petclinic.controller;

import com.spring.petclinic.domain.Vet;
import com.spring.petclinic.service.VetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class VetsController {
    private VetsService vetsService;

    @Autowired
    public VetsController(VetsService vetsService) {
        this.vetsService = vetsService;
    }

    @GetMapping("/vets")
    public String vets(Model model) {
        List<Vet> vets = vetsService.findVets();
        model.addAttribute("currentPage", "vets");
        model.addAttribute("vetsList", vets);
        return "vets/vetList";
    }
}
