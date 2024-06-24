package com.apprenant_p4.Gestion_Ticket.controller;

import com.apprenant_p4.Gestion_Ticket.modele.Admin;
import com.apprenant_p4.Gestion_Ticket.modele.BaseConnaissance;
import com.apprenant_p4.Gestion_Ticket.service.BaseConnaissanceService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/base")
@AllArgsConstructor
public class BaseConnaissanceController {
    private final BaseConnaissanceService baseConnaissanceService;

    @PostMapping("/create")
    public BaseConnaissance create(@RequestBody BaseConnaissance baseConnaissance){
        return baseConnaissanceService.creer(baseConnaissance);
    }

    @GetMapping("/read")
    public List<BaseConnaissance> read(){
        return baseConnaissanceService.lire();
    }

    @PutMapping("/update/{id}")
    public BaseConnaissance update(@PathVariable int id, @RequestBody BaseConnaissance baseConnaissance){
        return baseConnaissanceService.modifier(id, baseConnaissance);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        return baseConnaissanceService.supprimer(id);
    }
}
