package com.apprenant_p4.Gestion_Ticket.service;

import com.apprenant_p4.Gestion_Ticket.modele.Utilisateur;
import com.apprenant_p4.Gestion_Ticket.repository.UtilisateurRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserDetailService implements UserDetailsService {
    private final UtilisateurRepository utilisateurRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        System.out.println("Hello1");
        Utilisateur utilisateur = utilisateurRepository.findByEmail(email);
        System.out.println("Hello1");
        System.out.println(utilisateur.getEmail());
        System.out.println(utilisateur.getNom());
        System.out.println(utilisateur.getPassword());
        System.out.println(String.valueOf(utilisateur.getRoles()));

        return User.withUsername(utilisateur.getEmail()).
                password(utilisateur.getPassword()).
                roles(String.valueOf(utilisateur.getRoles())).
                build();
    }
}
