package com.hospital.controller;

import com.hospital.model.Payment;
import com.hospital.service.PaymentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/payments")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping
    public String listPayments(Model model) {
        model.addAttribute("payments", paymentService.getAllPayments());
        return "payment_list";
    }

    @GetMapping("/create")
    public String showForm(Model model) {
        model.addAttribute("payment", new Payment());
        return "payment_form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Payment payment) {
        paymentService.savePayment(payment);
        return "redirect:/payments";
    }
}
