package com.apprenant_p4.Gestion_Ticket.repository;

import com.apprenant_p4.Gestion_Ticket.modele.Apprenant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApprenantRepository extends JpaRepository<Apprenant, Integer> {
}
