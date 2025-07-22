package com.hospital.service;

import com.hospital.model.Administrator;
import com.hospital.repository.AdministratorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministratorService {
    private final AdministratorRepository repository;

    public AdministratorService(AdministratorRepository repository) {
        this.repository = repository;
    }

    public List<Administrator> getAllAdmins() {
        return repository.findAll();
    }

    public Administrator saveAdmin(Administrator admin) {
        return repository.save(admin);
    }
}
