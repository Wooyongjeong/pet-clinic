package com.spring.petclinic.controller;

import com.spring.petclinic.domain.Owner;
import com.spring.petclinic.domain.Pet;
import com.spring.petclinic.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class OwnersController {
    private OwnerService ownerService;

    @Autowired
    public OwnersController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping("/owners/find")
    public String findOwners(Model model) {
        model.addAttribute("currentPage", "owners");
        return "owners/findOwners";
    }

    @GetMapping("/owners/new")
    public String createForm() {
        return "owners/createOwnerForm";
    }

    @PostMapping("/owners/new")
    public String create(OwnerForm form) {
        Owner owner = new Owner(form);
        Long id = ownerService.join(owner);
        return "redirect:/owners/" + id;
    }

    @GetMapping("/owners")
    public String list(@RequestParam(value = "phone", required = false) String phone, Model model) {
        model.addAttribute("currentPage", "owners");
        if(phone.isBlank()) {
            List<Owner> owners = ownerService.findOwners();
            model.addAttribute("ownersList", owners);
            return "owners/ownersList";
        }
        else {
            Long ownerId = ownerService.findByPhone(phone);
            return String.format("redirect:/owners/%d", ownerId);
        }
    }

    @GetMapping("/owners/{id}")
    public String show(@PathVariable Long id, Model model) {
        model.addAttribute("currentPage", "owners");
        Owner owner = ownerService.findOne(id).get();
        model.addAttribute("owner", owner);
        List<Pet> pets = owner.getPets();
        if(!pets.isEmpty()) {
            model.addAttribute("pets", pets);
        }
        return "owners/showOwner";
    }

    @GetMapping("/owners/{id}/form")
    public String updateForm(@PathVariable Long id, Model model) {
        Owner owner = ownerService.findOne(id).get();
        model.addAttribute("currentPage", "owners");
        model.addAttribute("owner", owner);
        return "owners/updateOwnerForm";
    }

    @PutMapping("/owners/{id}")
    public String update(@PathVariable Long id, OwnerForm form) {
        Long ownerId = ownerService.update(id, form);
        return String.format("redirect:/owners/%d", ownerId);
    }

}
