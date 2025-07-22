package com.hospital.controller;

import com.hospital.model.Notification;
import com.hospital.model.Patient;
import com.hospital.service.NotificationService;
import com.hospital.service.PatientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/notifications")
public class NotificationController {

    private final NotificationService notificationService;
    private final PatientService patientService;

    public NotificationController(NotificationService notificationService, PatientService patientService) {
        this.notificationService = notificationService;
        this.patientService = patientService;
    }

    @GetMapping
    public String listNotifications(Model model) {
        model.addAttribute("notifications", notificationService.getAllNotifications());
        return "notifications";
    }

    @GetMapping("/create")
    public String showForm(Model model) {
        model.addAttribute("notification", new Notification());
        model.addAttribute("patients", patientService.getAllPatients());
        return "notification_form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Notification notification) {
        notification.setTimestamp(LocalDateTime.now());
        notificationService.saveNotification(notification);
        return "redirect:/notifications";
    }
}
