package com.hospital.service;

import com.hospital.model.Receptionist;
import com.hospital.repository.ReceptionistRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReceptionistService {
    private final ReceptionistRepository repository;

    public ReceptionistService(ReceptionistRepository repository) {
        this.repository = repository;
    }

    public List<Receptionist> getAllReceptionists() {
        return repository.findAll();
    }

    public Receptionist saveReceptionist(Receptionist receptionist) {
        return repository.save(receptionist);
    }
}
