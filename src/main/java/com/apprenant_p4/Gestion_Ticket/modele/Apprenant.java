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
@DiscriminatorValue("apprenant")

public class Apprenant extends Utilisateur{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(mappedBy = "apprenant")
    private List<Ticket> tickets;

    @OneToMany(mappedBy = "apprenant")
    private List<BaseConnaissance> baseConnaissances;

    @ManyToOne
    private Formateur formateur;
}
