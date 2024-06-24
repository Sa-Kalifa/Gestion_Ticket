package com.apprenant_p4.Gestion_Ticket.service;

import com.apprenant_p4.Gestion_Ticket.modele.Apprenant;

import java.util.List;

public interface ApprenantService {
    Apprenant creer(Apprenant apprenant);
    List<Apprenant> lire();
    Apprenant modifier(int id, Apprenant apprenant);
    String supprimer(int id);
}
