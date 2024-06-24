package com.apprenant_p4.Gestion_Ticket.controller;

import com.apprenant_p4.Gestion_Ticket.modele.Utilisateur;
import com.apprenant_p4.Gestion_Ticket.repository.UtilisateurRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class RegisterLoginForm {
    private final PasswordEncoder passwordEncoder;
    private final UtilisateurRepository utilisateurRepository;
    private final AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody Utilisateur utilisateur) {
        if(utilisateurRepository.findByEmail(utilisateur.getEmail()) != null){
            return ResponseEntity.badRequest().body("Cet Utilisateur n'existe pas !!");
        }
        utilisateur.setMdp(passwordEncoder.encode(utilisateur.getMdp()));
        return ResponseEntity.ok(utilisateurRepository.save(utilisateur));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Utilisateur utilisateur) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(utilisateur.getEmail(), utilisateur.getMdp()));
            return ResponseEntity.ok("Connecter avec Succes");
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Email ou mot de passe incorrect");
        }
    }

}
