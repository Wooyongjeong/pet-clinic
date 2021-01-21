package com.spring.petclinic.controller;

import com.spring.petclinic.domain.Owner;
import com.spring.petclinic.domain.Pet;
import com.spring.petclinic.service.OwnerService;
import com.spring.petclinic.service.PetService;
import com.spring.petclinic.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
public class PetController {
    private OwnerService ownerService;
    private PetService petService;

    @Autowired
    public PetController(OwnerService ownerService, PetService petService) {
        this.ownerService = ownerService;
        this.petService = petService;
    }

    @GetMapping("/owners/{id}/pets/new")
    public String createPetForm(@PathVariable Long id, Model model) {
        model.addAttribute("currentPage", "owners");
        Owner owner = ownerService.findOne(id).get();
        model.addAttribute("ownerId", owner.getId());
        model.addAttribute("ownerName", owner.getName());
        return "pets/createPetForm";
    }

    @PostMapping("/owners/{ownerId}/pets/new")
    public String createPet(@PathVariable Long ownerId, PetForm form) {
        Owner owner = ownerService.findOne(ownerId).get();
        Pet pet = new Pet(form);
        petService.join(pet, owner);
        return String.format("redirect:/owners/%d", ownerId);
    }

    @GetMapping("/pets/{id}/form")
    public String updateForm(@PathVariable Long id, Model model) {
        model.addAttribute("currentPage", "owners");
        model.addAttribute("pet", petService.findOne(id).get());
        return "pets/updatePetForm";
    }

    @PutMapping("/pets/{id}")
    public String update(@PathVariable Long id, PetForm form) {
        Long ownerId = petService.update(id, form).getOwner().getId();
        return String.format("redirect:/owners/%d", ownerId);
    }

}
