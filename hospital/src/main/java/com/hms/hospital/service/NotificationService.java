package com.hospital.service;

import com.hospital.model.Notification;
import com.hospital.repository.NotificationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {
    private final NotificationRepository repository;

    public NotificationService(NotificationRepository repository) {
        this.repository = repository;
    }

    public List<Notification> getAllNotifications() {
        return repository.findAll();
    }

    public Notification saveNotification(Notification notification) {
        return repository.save(notification);
    }
}
