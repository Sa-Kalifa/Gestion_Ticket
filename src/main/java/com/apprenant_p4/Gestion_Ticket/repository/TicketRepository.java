package com.apprenant_p4.Gestion_Ticket.repository;

import com.apprenant_p4.Gestion_Ticket.modele.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {
}
