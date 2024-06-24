package com.apprenant_p4.Gestion_Ticket.service;

import com.apprenant_p4.Gestion_Ticket.modele.Admin;
import com.apprenant_p4.Gestion_Ticket.modele.Formateur;

import java.util.List;

public interface FormateurService {
    Formateur creer(Formateur formateur);
    List<Formateur> lire();
    Formateur modifier(int id, Formateur formateur);
    String supprimer(int id);
}
