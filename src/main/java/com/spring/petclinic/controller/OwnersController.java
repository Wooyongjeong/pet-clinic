package com.spring.petclinic.controller;

import com.spring.petclinic.domain.Owner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OwnersController {
    @GetMapping("/owners/find")
    public String findOwners(Model model) {
        model.addAttribute("currentPage", "findOwners");
        return "owners/findOwners";
    }

    @PostMapping("/owners/find")
    public String findOwnersByName(@RequestParam("name") String name, Model model) {
        System.out.println(name);
        return "redirect:/";
    }

    @GetMapping("/owners/new")
    public String createForm() {
        return "owners/createForm";
    }

    @PostMapping("/owners/new")
    public String create(OwnerForm form) {
        Owner owner = new Owner();

        return "redirect:/";
    }
}
