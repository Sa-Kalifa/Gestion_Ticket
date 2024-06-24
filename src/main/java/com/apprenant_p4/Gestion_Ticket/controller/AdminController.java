package com.apprenant_p4.Gestion_Ticket.controller;

import com.apprenant_p4.Gestion_Ticket.modele.Admin;
import com.apprenant_p4.Gestion_Ticket.service.AminService;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;

@RestController
@RequestMapping("/admin")
@AllArgsConstructor

public class AdminController {
    private final AminService aminService;
    private final FormateurController formateurController;

    @PostMapping("/create")
    public Admin create(@RequestBody Admin admin){
        return aminService.creer(admin);
    }

    @GetMapping("/read")
    public List<Admin> read(){
        return aminService.lire();
    }

    @PutMapping("/update/{id}")
    public Admin update(@PathVariable int id, @RequestBody Admin admin){
        return aminService.modifier(id, admin);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        return aminService.supprimer(id);
    }
}
