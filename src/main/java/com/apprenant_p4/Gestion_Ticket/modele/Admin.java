package com.apprenant_p4.Gestion_Ticket.modele;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity

@DiscriminatorValue("admin")

public class Admin extends Utilisateur{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(mappedBy = "admin")
    private List<Formateur> formateur;

    @OneToMany(mappedBy = "admin")
    private List<BaseConnaissance> baseConnaissances;
}
