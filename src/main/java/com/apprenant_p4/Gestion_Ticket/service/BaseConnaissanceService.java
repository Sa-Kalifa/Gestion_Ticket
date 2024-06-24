package com.apprenant_p4.Gestion_Ticket.service;

import com.apprenant_p4.Gestion_Ticket.modele.Admin;
import com.apprenant_p4.Gestion_Ticket.modele.BaseConnaissance;

import java.util.List;

public interface BaseConnaissanceService {
    BaseConnaissance creer(BaseConnaissance baseConnaissance);
    List<BaseConnaissance> lire();
    BaseConnaissance modifier(int id, BaseConnaissance baseConnaissance);
    String supprimer(int id);
}
