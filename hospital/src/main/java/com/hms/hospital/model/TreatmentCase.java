package com.hospital.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class TreatmentCase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String caseDetails;
    private LocalDate dateOpened;

    @ManyToOne
    private Patient patient;

    @ManyToOne
    private Doctor doctor;

    // Getters and Setters
}
