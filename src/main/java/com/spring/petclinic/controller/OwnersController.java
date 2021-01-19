package com.spring.petclinic.controller;

import com.spring.petclinic.domain.Owner;
import com.spring.petclinic.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @PostMapping("/owners/find")
    public String findOwnersByName(@RequestParam("name") String name, Model model) {
        System.out.println(name);
        return "redirect:/";
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
    public String list(Model model) {
        List<Owner> owners = ownerService.findOwners();
        model.addAttribute("currentPage", "owners");
        model.addAttribute("ownersList", owners);
        return "owners/ownersList";
    }

    @GetMapping("/owners/{id}")
    public String show(@PathVariable Long id, Model model) {
        Owner owner = ownerService.findOne(id).get();
        model.addAttribute("currentPage", "owners");
        model.addAttribute("owner", owner);
        return "owners/showOwner";
    }

    @GetMapping("/owners/{id}/form")
    public String updateForm(@PathVariable Long id, Model model) {
        Owner owner = ownerService.findOne(id).get();
        model.addAttribute("currentPage", "owners");
        model.addAttribute("owner", owner);
        return "owners/updateOwnerForm";
    }
}
