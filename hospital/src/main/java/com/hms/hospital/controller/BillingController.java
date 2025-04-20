package com.hospital.controller;

import com.hospital.model.Billing;
import com.hospital.model.Patient;
import com.hospital.service.BillingService;
import com.hospital.service.PatientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/billings")
public class BillingController {

    private final BillingService billingService;
    private final PatientService patientService;

    public BillingController(BillingService billingService, PatientService patientService) {
        this.billingService = billingService;
        this.patientService = patientService;
    }

    @GetMapping
    public String listBillings(Model model) {
        List<Billing> billings = billingService.getAllBillings();
        model.addAttribute("billings", billings);
        return "billing_list";
    }

    @GetMapping("/create")
    public String showBillingForm(Model model) {
        model.addAttribute("billing", new Billing());
        model.addAttribute("patients", patientService.getAllPatients());
        return "billing_form";
    }

    @PostMapping("/save")
    public String saveBilling(@ModelAttribute Billing billing) {
        billingService.saveBilling(billing);
        return "redirect:/billings";
    }
}
