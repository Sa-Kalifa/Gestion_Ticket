package com.apprenant_p4.Gestion_Ticket.service;

import com.apprenant_p4.Gestion_Ticket.modele.Admin;
import com.apprenant_p4.Gestion_Ticket.modele.Ticket;

import java.util.List;

public interface TicketService {
    Ticket creer(Ticket ticket);
    List<Ticket> lire();
    Ticket modifier(int id, Ticket ticket);
    String supprimer(int id);
}
