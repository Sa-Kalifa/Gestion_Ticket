package com.apprenant_p4.Gestion_Ticket.service;

import com.apprenant_p4.Gestion_Ticket.modele.Apprenant;
import com.apprenant_p4.Gestion_Ticket.modele.Ticket;
import com.apprenant_p4.Gestion_Ticket.repository.TicketRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class TicketServiceImpl implements TicketService{
    private final TicketRepository ticketRepository;

    @Override
    public Ticket creer(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    @Override
    public List<Ticket> lire() {
        return ticketRepository.findAll();
    }

    @Override
    public Ticket modifier(int id, Ticket ticket) {
        return ticketRepository.findById(id).map(p -> {
            p.setDescription(ticket.getDescription());
            p.setCategorie(ticket.getCategorie());
            p.setPriorite(ticket.getPriorite());
            p.setDateCreation(ticket.getDateCreation());
            return ticketRepository.save(p);
        }).orElseThrow(() -> new RuntimeException("Ticket nom Trouver"));
    }

    @Override
    public String supprimer(int id) {
        ticketRepository.deleteById(id);
        return "Ticket Supprimer avec succes";
    }
}
