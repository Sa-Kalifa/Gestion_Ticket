package com.apprenant_p4.Gestion_Ticket.service;

import com.apprenant_p4.Gestion_Ticket.modele.Utilisateur;
import jakarta.persistence.Id;

import java.util.List;

public interface UtilisateurService {

    Utilisateur creer(Utilisateur utilisateur);
    List<Utilisateur> lire();
    Utilisateur modifier(int Id, Utilisateur utilisateur);
    String supprimer(int id);
}
