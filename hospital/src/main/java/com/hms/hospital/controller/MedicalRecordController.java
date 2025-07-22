package com.hospital.controller;

import com.hospital.model.MedicalReport;
import com.hospital.service.MedicalReportService;
import com.hospital.service.PatientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/medical-records")
public class MedicalRecordController {

    private final MedicalReportService reportService;
    private final PatientService patientService;

    public MedicalRecordController(MedicalReportService reportService, PatientService patientService) {
        this.reportService = reportService;
        this.patientService = patientService;
    }

    @GetMapping
    public String listRecords(Model model) {
        model.addAttribute("records", reportService.getAllReports());
        return "medical_records";
    }

    @GetMapping("/create")
    public String showForm(Model model) {
        model.addAttribute("record", new MedicalReport());
        model.addAttribute("patients", patientService.getAllPatients());
        return "medical_record_form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute MedicalReport record) {
        reportService.saveReport(record);
        return "redirect:/medical-records";
    }
}
