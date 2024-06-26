package com.apprenant_p4.Gestion_Ticket.service;


import com.apprenant_p4.Gestion_Ticket.modele.Utilisateur;
import com.apprenant_p4.Gestion_Ticket.repository.UtilisateurRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class UtilisateurServiceImpl implements UtilisateurService{
    private final UtilisateurRepository utilisateurRepository;
    @Override
    public Utilisateur creer(Utilisateur utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }

    @Override
    public List<Utilisateur> lire() {
        return utilisateurRepository.findAll();
    }


    @Override
    public Utilisateur modifier(int Id, Utilisateur utilisateur) {
        return utilisateurRepository.findById(Id).map(p -> {
            p.setNom(utilisateur.getNom());
            p.setEmail(utilisateur.getEmail());
            p.setPassword(utilisateur.getPassword());
            p.setRoles(utilisateur.getRoles());
            return utilisateurRepository.save(p);
        }).orElseThrow(()-> new RuntimeException("Cet utilisateur n'existe pas !!"));
    }

    @Override
    public String supprimer(int id) {
        utilisateurRepository.deleteById(id);
        return "Utilisateur Supprimer avec Succes !!";
    }
}
