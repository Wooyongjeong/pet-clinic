package com.spring.petclinic.controller;

import com.spring.petclinic.domain.Pet;
import com.spring.petclinic.domain.Visit;
import com.spring.petclinic.service.PetService;
import com.spring.petclinic.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class VisitController {
    private PetService petService;
    private VisitService visitService;

    @Autowired
    public VisitController(PetService petService, VisitService visitService) {
        this.petService = petService;
        this.visitService = visitService;
    }

    @GetMapping("/pets/{id}/visits")
    public String showVisits(@PathVariable Long id, Model model) {
        model.addAttribute("currentPage", "owners");
        model.addAttribute("pet", petService.findOne(id).get());
        List<Visit> visits = visitService.findByPetId(id);
        if(!visits.isEmpty()) {
            model.addAttribute("visits", visits);
        }
        return "visits/showVisit";
    }

    @PostMapping("/pets/{id}/visits/new")
    public String createVisit(@PathVariable Long id, VisitForm form) {
        Pet pet = petService.findOne(id).get();
        Visit visit = new Visit(form);
        Long joinVisit = visitService.join(visit, pet);
        return String.format("redirect:/pets/%d/visits", id);
    }
}
