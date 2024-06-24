package com.apprenant_p4.Gestion_Ticket.service;

import com.apprenant_p4.Gestion_Ticket.modele.Apprenant;
import com.apprenant_p4.Gestion_Ticket.repository.ApprenantRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ApprenantServiceImpl implements ApprenantService{
    private final ApprenantRepository apprenantRepository;

    @Override
    public Apprenant creer(Apprenant apprenant) {
        return apprenantRepository.save(apprenant);
    }

    @Override
    public List<Apprenant> lire() {
        return apprenantRepository.findAll();
    }

    @Override
    public Apprenant modifier(int id, Apprenant apprenant) {
        return apprenantRepository.findById(id).map(p -> {
            p.setNom(apprenant.getNom());
            p.setEmail(apprenant.getEmail());
            p.setMdp(apprenant.getMdp());
            return apprenantRepository.save(p);
        }).orElseThrow(() -> new RuntimeException("Apprenant nom Trouver"));
    }

    @Override
    public String supprimer(int id) {
        apprenantRepository.deleteById(id);
        return "Apprenant Supprimer avec Succes";
    }
}
