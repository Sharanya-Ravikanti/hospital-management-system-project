package com.hospital.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class MedicalReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String diagnosis;
    private String treatment;
    private LocalDate reportDate;

    @ManyToOne
    private Patient patient;

    // Getters and Setters
}
