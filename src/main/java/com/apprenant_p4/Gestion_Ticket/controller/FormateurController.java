package com.apprenant_p4.Gestion_Ticket.controller;

import com.apprenant_p4.Gestion_Ticket.modele.Admin;
import com.apprenant_p4.Gestion_Ticket.modele.Formateur;
import com.apprenant_p4.Gestion_Ticket.service.FormateurService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/formateur")
@AllArgsConstructor
public class FormateurController {
    private final FormateurService formateurService;
    @PostMapping("/create")
    public Formateur create(@RequestBody Formateur formateur){
        return formateurService.creer(formateur);
    }

    @GetMapping("/read")
    public List<Formateur> read(){
        return formateurService.lire();
    }

    @PutMapping("/update/{id}")
    public Formateur update(@PathVariable int id, @RequestBody Formateur formateur){
        return formateurService.modifier(id, formateur);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        return formateurService.supprimer(id);
    }
}
