package com.hospital.service;

import com.hospital.model.MedicalReport;
import com.hospital.repository.MedicalReportRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalReportService {
    private final MedicalReportRepository repository;

    public MedicalReportService(MedicalReportRepository repository) {
        this.repository = repository;
    }

    public List<MedicalReport> getAllReports() {
        return repository.findAll();
    }

    public MedicalReport saveReport(MedicalReport report) {
        return repository.save(report);
    }

    public MedicalReport getReportById(Long id) {
        return repository.findById(id).orElse(null);
    }
}
