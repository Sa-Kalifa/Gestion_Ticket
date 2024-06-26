package com.apprenant_p4.Gestion_Ticket.controller;

import com.apprenant_p4.Gestion_Ticket.modele.BaseConnaissance;
import com.apprenant_p4.Gestion_Ticket.service.BaseConnaissanceService;
import com.apprenant_p4.Gestion_Ticket.service.TicketServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/formateur")
@AllArgsConstructor
public class Formateur {
    private final BaseConnaissanceService baseConnaissanceService;
    private final TicketServiceImpl ticketServiceImpl;

    @PostMapping("/base/Ajouter")
    public BaseConnaissance create(@RequestBody BaseConnaissance baseConnaissance){
        return baseConnaissanceService.creer(baseConnaissance);
    }

    @GetMapping("/base/Afficher")
    public List<BaseConnaissance> read(){
        return baseConnaissanceService.lire();
    }

    @PutMapping("/base/modifier/{id}")
    public BaseConnaissance update(@PathVariable int id, @RequestBody BaseConnaissance baseConnaissance){
        return baseConnaissanceService.modifier(id, baseConnaissance);
    }

    @DeleteMapping("/base/supprimer/{id}")
    public String delete(@PathVariable int id){
        return baseConnaissanceService.supprimer(id);
    }

    @PutMapping("/ticket/{id}/reponse")
    public ResponseEntity<?> repondreAuTicket(@PathVariable int id, @RequestBody String reponse){
        ticketServiceImpl.repondreAuTicket(id, reponse);
        return ResponseEntity.ok().build();
    }
}
