package com.apprenant_p4.Gestion_Ticket.service;

import com.apprenant_p4.Gestion_Ticket.modele.Admin;

import java.util.List;

public interface AminService {
    Admin creer(Admin admin);
    List<Admin> lire();
    Admin modifier(int id, Admin admin);
    String supprimer(int id);
}
