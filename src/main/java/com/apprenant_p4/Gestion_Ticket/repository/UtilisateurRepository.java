package com.apprenant_p4.Gestion_Ticket.repository;

import com.apprenant_p4.Gestion_Ticket.modele.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {
    Utilisateur findByEmail(String email);

}
