package com.apprenant_p4.Gestion_Ticket.controller;

import com.apprenant_p4.Gestion_Ticket.modele.Admin;
import com.apprenant_p4.Gestion_Ticket.modele.Apprenant;
import com.apprenant_p4.Gestion_Ticket.service.ApprenantService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apprenant")
@AllArgsConstructor


public class ApprenantController {
    private final ApprenantService apprenantService;
    @PostMapping("/create")
    public Apprenant create(@RequestBody Apprenant apprenant){
        return apprenantService.creer(apprenant);
    }

    @GetMapping("/read")
    public List<Apprenant> read(){
        return apprenantService.lire();
    }

    @PutMapping("/update/{id}")
    public Apprenant update(@PathVariable int id, @RequestBody Apprenant apprenant){
        return apprenantService.modifier(id, apprenant);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        return apprenantService.supprimer(id);
    }
}
