package com.apprenant_p4.Gestion_Ticket.controller;

import com.apprenant_p4.Gestion_Ticket.modele.Utilisateur;
import com.apprenant_p4.Gestion_Ticket.service.UtilisateurService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
@AllArgsConstructor

public class Admin {
    private final UtilisateurService utilisateurService;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/Ajouter")
    public Utilisateur create(@RequestBody Utilisateur utilisateur) {
        utilisateur.setPassword(passwordEncoder.encode(utilisateur.getPassword()));
        return utilisateurService.creer(utilisateur);
    }

    @GetMapping("/Afficher")
    public List<Utilisateur> read(){
        return utilisateurService.lire();
    }

    @PutMapping("/modifier/{id}")
    public Utilisateur update(@PathVariable int id, @RequestBody Utilisateur utilisateur) {
        return utilisateurService.modifier(id, utilisateur);
    }

    @DeleteMapping("/supprimer/{id}")
    public String delete(@PathVariable int id) {
        return utilisateurService.supprimer(id);
    }
}
