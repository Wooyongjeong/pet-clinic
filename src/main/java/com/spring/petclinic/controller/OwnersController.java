package com.spring.petclinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OwnersController {
    @GetMapping("/owners/find")
    public String findOwners(Model model) {
        model.addAttribute("currentPage", "findOwners");
        return "owners/findOwners";
    }
}
