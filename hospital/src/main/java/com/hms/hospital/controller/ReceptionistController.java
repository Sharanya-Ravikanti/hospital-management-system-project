package com.hospital.controller;

import com.hospital.model.Receptionist;
import com.hospital.service.ReceptionistService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/receptionists")
public class ReceptionistController {

    private final ReceptionistService receptionistService;

    public ReceptionistController(ReceptionistService receptionistService) {
        this.receptionistService = receptionistService;
    }

    @GetMapping
    public String listReceptionists(Model model) {
        model.addAttribute("receptionists", receptionistService.getAllReceptionists());
        return "receptionist_list";
    }

    @GetMapping("/create")
    public String showForm(Model model) {
        model.addAttribute("receptionist", new Receptionist());
        return "receptionist_form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Receptionist receptionist) {
        receptionistService.saveReceptionist(receptionist);
        return "redirect:/receptionists";
    }
}
