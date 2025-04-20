package com.hospital.service;

import com.hospital.model.Payment;
import com.hospital.repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    private final PaymentRepository repository;

    public PaymentService(PaymentRepository repository) {
        this.repository = repository;
    }

    public List<Payment> getAllPayments() {
        return repository.findAll();
    }

    public Payment savePayment(Payment payment) {
        return repository.save(payment);
    }
}
