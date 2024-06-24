package com.apprenant_p4.Gestion_Ticket.controller;

import com.apprenant_p4.Gestion_Ticket.modele.Admin;
import com.apprenant_p4.Gestion_Ticket.modele.Ticket;
import com.apprenant_p4.Gestion_Ticket.service.TicketService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ticket")
@AllArgsConstructor

public class TicketController {
    private final TicketService ticketService;
    @PostMapping("/create")
    public Ticket create(@RequestBody Ticket ticket){
        return ticketService.creer(ticket);
    }

    @GetMapping("/read")
    public List<Ticket> read(){
        return ticketService.lire();
    }

    @PutMapping("/update/{id}")
    public Ticket update(@PathVariable int id, @RequestBody Ticket ticket){
        return ticketService.modifier(id, ticket);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        return ticketService.supprimer(id);
    }
}
