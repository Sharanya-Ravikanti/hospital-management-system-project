package com.hospital.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Billing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double amount;

    private LocalDate billingDate;

    private String description;

    @ManyToOne
    private Patient patient;

    // Getters and Setters
}
