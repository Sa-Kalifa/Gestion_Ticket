package com.apprenant_p4.Gestion_Ticket.service;

import com.apprenant_p4.Gestion_Ticket.modele.Formateur;
import com.apprenant_p4.Gestion_Ticket.repository.FormateurRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class FormateurServiceImpl implements FormateurService{
    private final FormateurRepository formateurRepository;

    @Override
    public Formateur creer(Formateur formateur) {
        return formateurRepository.save(formateur);
    }

    @Override
    public List<Formateur> lire() {
        return formateurRepository.findAll();
    }

    @Override
    public Formateur modifier(int id, Formateur formateur) {
        return formateurRepository.findById(id).map(p -> {
            p.setNom(formateur.getNom());
            p.setEmail(formateur.getEmail());
            p.setMdp(formateur.getMdp());
            return formateurRepository.save(p);
        }).orElseThrow(() -> new RuntimeException("Formateur nom Trouver"));
    }

    @Override
    public String supprimer(int id) {
        formateurRepository.deleteById(id);
        return "Formateur Supprimer avec Succes";
    }
}
