package com.hospital.model;

import jakarta.persistence.*;

@Entity
public class Receptionist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String contact;
    private String email;

    // Getters and Setters
}
