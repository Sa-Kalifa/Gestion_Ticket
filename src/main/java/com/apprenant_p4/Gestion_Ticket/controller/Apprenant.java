package com.apprenant_p4.Gestion_Ticket.controller;

import com.apprenant_p4.Gestion_Ticket.modele.BaseConnaissance;
import com.apprenant_p4.Gestion_Ticket.modele.Ticket;
import com.apprenant_p4.Gestion_Ticket.service.BaseConnaissanceService;
import com.apprenant_p4.Gestion_Ticket.service.TicketService;
import com.apprenant_p4.Gestion_Ticket.service.TicketServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apprenant")
@AllArgsConstructor
public class Apprenant {
    private final TicketService ticketService;
    private final BaseConnaissanceService baseConnaissanceService;

    @PostMapping("/ticket/Ajouter")
    public Ticket create(@RequestBody Ticket ticket){
        return ticketService.creer(ticket);
    }

    @GetMapping("/ticket/Afficher")
    public List<Ticket> read(){
        return ticketService.lire();
    }

    @PutMapping("/ticket/modifier/{id}")
    public Ticket update(@PathVariable int id, @RequestBody Ticket ticket){
        return ticketService.modifier(id, ticket);
    }

    @DeleteMapping("/ticket/supprimer/{id}")
    public String delete(@PathVariable int id){
        return ticketService.supprimer(id);
    }

    @GetMapping("/base/Afficher")
    public List<BaseConnaissance> Afficher(){
        return baseConnaissanceService.lire();
    }

}
