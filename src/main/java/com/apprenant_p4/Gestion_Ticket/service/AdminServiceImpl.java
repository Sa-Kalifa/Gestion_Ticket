package com.apprenant_p4.Gestion_Ticket.service;

import com.apprenant_p4.Gestion_Ticket.modele.Admin;
import com.apprenant_p4.Gestion_Ticket.modele.Apprenant;
import com.apprenant_p4.Gestion_Ticket.repository.AdminRepository;
import com.apprenant_p4.Gestion_Ticket.repository.ApprenantRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class AdminServiceImpl implements AminService {
    private final AdminRepository adminRepository;

    @Override
    public Admin creer(Admin admin) {
        return adminRepository.save(admin);
    }

    @Override
    public List<Admin> lire() {
        return adminRepository.findAll();
    }

    @Override
    public Admin modifier(int id, Admin admin) {
        return adminRepository.findById(id).map(p -> {
            p.setNom(admin.getNom());
            p.setEmail(admin.getEmail());
            p.setMdp(admin.getMdp());
            return adminRepository.save(p);
        }).orElseThrow(() -> new RuntimeException("Administracteur nom Trouver"));
    }

    @Override
    public String supprimer(int id) {
        adminRepository.deleteById(id);
        return "Administracteur Supprimer avec Succes";
    }
}
