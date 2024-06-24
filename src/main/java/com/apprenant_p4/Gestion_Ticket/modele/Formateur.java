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
@DiscriminatorValue("formateur")

public class Formateur extends Utilisateur{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(mappedBy = "formateur")
    private List<Apprenant> apprenants;

    @OneToMany(mappedBy = "formateur")
    private List<Ticket> tickets;

    @OneToMany(mappedBy = "formateur")
    private List<BaseConnaissance> baseConnaissances;

    @ManyToOne
    private Admin admin;
}
