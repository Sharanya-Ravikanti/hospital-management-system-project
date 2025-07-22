package com.hospital.service;

import com.hospital.model.TreatmentCase;
import com.hospital.repository.TreatmentCaseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TreatmentCaseService {
    private final TreatmentCaseRepository repository;

    public TreatmentCaseService(TreatmentCaseRepository repository) {
        this.repository = repository;
    }

    public List<TreatmentCase> getAllCases() {
        return repository.findAll();
    }

    public TreatmentCase saveCase(TreatmentCase treatmentCase) {
        return repository.save(treatmentCase);
    }

    public TreatmentCase getById(Long id) {
        return repository.findById(id).orElse(null);
    }
}
