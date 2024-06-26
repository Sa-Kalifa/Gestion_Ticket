package com.apprenant_p4.Gestion_Ticket.service;

import com.apprenant_p4.Gestion_Ticket.modele.BaseConnaissance;
import com.apprenant_p4.Gestion_Ticket.repository.BaseConnaissanceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class BaseConnaissanceServiceImpl implements BaseConnaissanceService{
    private final BaseConnaissanceRepository baseConnaissanceRepository;

    @Override
    public BaseConnaissance creer(BaseConnaissance baseConnaissance) {
        return baseConnaissanceRepository.save(baseConnaissance);
    }

    @Override
    public List<BaseConnaissance> lire() {
        return baseConnaissanceRepository.findAll();
    }

    @Override
    public BaseConnaissance modifier(int id, BaseConnaissance baseConnaissance) {
        return baseConnaissanceRepository.findById(id).map(p -> {
            p.setTitre(baseConnaissance.getTitre());
            p.setContenu(baseConnaissance.getContenu());
            return baseConnaissanceRepository.save(p);
        }).orElseThrow(() -> new RuntimeException("Base nom Trouver"));
    }

    @Override
    public String supprimer(int id) {
        baseConnaissanceRepository.deleteById(id);
        return "Base Supprimer avec Succes";

    }
}
