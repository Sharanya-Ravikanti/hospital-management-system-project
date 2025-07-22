package com.hospital.controller;

import com.hospital.model.Administrator;
import com.hospital.service.AdministratorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admins")
public class AdministratorController {

    private final AdministratorService adminService;

    public AdministratorController(AdministratorService adminService) {
        this.adminService = adminService;
    }

    @GetMapping
    public String listAdmins(Model model) {
        model.addAttribute("admins", adminService.getAllAdmins());
        return "admin_list";
    }

    @GetMapping("/create")
    public String showForm(Model model) {
        model.addAttribute("admin", new Administrator());
        return "admin_form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Administrator admin) {
        adminService.saveAdmin(admin);
        return "redirect:/admins";
    }
}
