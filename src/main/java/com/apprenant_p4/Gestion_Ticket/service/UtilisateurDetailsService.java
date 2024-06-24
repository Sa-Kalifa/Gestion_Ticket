package com.apprenant_p4.Gestion_Ticket.service;

import com.apprenant_p4.Gestion_Ticket.modele.Utilisateur;
import com.apprenant_p4.Gestion_Ticket.repository.UtilisateurRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UtilisateurDetailsService implements UserDetailsService {

    private final UtilisateurRepository utilisateurRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Utilisateur utilisateur = utilisateurRepository.findByEmail(email);
        if (utilisateur == null) {
            throw new UsernameNotFoundException("Adresse Email ou Mot de passe Incorrecte : " + email);
        }

        // Create a list of authorities
        List<SimpleGrantedAuthority> authorities = utilisateur.getRoles().stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());

        return new org.springframework.security.core.userdetails.User(
                utilisateur.getEmail(), // Spring Security requires username as email
                utilisateur.getMdp(), // Spring Security requires password
                authorities
        );
    }

    public void afficherRolesUtilisateur(int utilisateurId) {
        Optional<Utilisateur> utilisateurOpt = utilisateurRepository.findById(utilisateurId);
        if (utilisateurOpt.isPresent()) {
            Utilisateur utilisateur = utilisateurOpt.get();
            Set<String> roles = utilisateur.getRoles();
            System.out.println("Les rôles de l'utilisateur sont : " + roles);
        } else {
            System.out.println("Utilisateur non trouvé");
        }

    }
}