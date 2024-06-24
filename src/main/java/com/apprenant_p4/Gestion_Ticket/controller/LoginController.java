/* package com.apprenant_p4.Gestion_Ticket.controller;

import com.apprenant_p4.Gestion_Ticket.modele.Admin;
import com.apprenant_p4.Gestion_Ticket.modele.Apprenant;
import com.apprenant_p4.Gestion_Ticket.modele.Formateur;
import com.apprenant_p4.Gestion_Ticket.repository.UtilisateurRepository;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class LoginController {

    private UtilisateurRepository utilisateurRepository;
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    public void init() {
        initUsers();
    }

    private void initUsers() {
        if (utilisateurRepository.count() == 0) {
            Set<String> adminRoles = new HashSet<>();
            adminRoles.add("ROLE_ADMIN");

            Admin admin = new Admin();
            admin.setNom("Admin");
            admin.setEmail("admin@example.com");
            admin.setMdp(passwordEncoder.encode("password"));
            admin.setRoles(adminRoles);

            utilisateurRepository.save(admin);

            Set<String> formateurRoles = new HashSet<>();
            formateurRoles.add("ROLE_FORMATEUR");

            Formateur formateur = new Formateur();
            formateur.setNom("Formateur");
            formateur.setEmail("formateur@example.com");
            formateur.setMdp(passwordEncoder.encode("password"));
            formateur.setRoles(formateurRoles);

            utilisateurRepository.save(formateur);

            Set<String> apprenantRoles = new HashSet<>();
            apprenantRoles.add("ROLE_APPRENANT");

            Apprenant apprenant = new Apprenant();
            apprenant.setNom("Apprenant");
            apprenant.setEmail("apprenant@example.com");
            apprenant.setMdp(passwordEncoder.encode("password"));
            apprenant.setRoles(apprenantRoles);

            utilisateurRepository.save(apprenant);
        }
    }
} */
