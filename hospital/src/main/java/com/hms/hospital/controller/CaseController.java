package com.hospital.controller;

import com.hospital.model.TreatmentCase;
import com.hospital.service.DoctorService;
import com.hospital.service.PatientService;
import com.hospital.service.TreatmentCaseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cases")
public class CaseController {

    private final TreatmentCaseService caseService;
    private final PatientService patientService;
    private final DoctorService doctorService;

    public CaseController(TreatmentCaseService caseService, PatientService patientService, DoctorService doctorService) {
        this.caseService = caseService;
        this.patientService = patientService;
        this.doctorService = doctorService;
    }

    @GetMapping
    public String listCases(Model model) {
        model.addAttribute("cases", caseService.getAllCases());
        return "case_handling";
    }

    @GetMapping("/create")
    public String showForm(Model model) {
        model.addAttribute("caseObj", new TreatmentCase());
        model.addAttribute("patients", patientService.getAllPatients());
        model.addAttribute("doctors", doctorService.getAllDoctors());
        return "case_form";
    }

    @PostMapping("/save")
    public String saveCase(@ModelAttribute("caseObj") TreatmentCase treatmentCase) {
        caseService.saveCase(treatmentCase);
        return "redirect:/cases";
    }
}
