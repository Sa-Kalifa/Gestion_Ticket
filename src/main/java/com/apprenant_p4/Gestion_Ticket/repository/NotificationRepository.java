package com.apprenant_p4.Gestion_Ticket.repository;

import com.apprenant_p4.Gestion_Ticket.modele.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Integer> {
}
