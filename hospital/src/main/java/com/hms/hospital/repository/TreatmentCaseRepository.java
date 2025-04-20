package com.hospital.repository;

import com.hospital.model.TreatmentCase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TreatmentCaseRepository extends JpaRepository<TreatmentCase, Long> {
}
