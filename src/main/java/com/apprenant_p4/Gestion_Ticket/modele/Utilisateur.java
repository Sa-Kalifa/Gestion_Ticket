package com.apprenant_p4.Gestion_Ticket.modele;

import com.apprenant_p4.Gestion_Ticket.modele.Enum.Roles;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "utilisateur")

public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    @Column(unique = true)
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private Roles roles;

    @OneToMany(mappedBy = "utilisateur")
    private List<BaseConnaissance> baseConnaissances;

    @OneToMany(mappedBy = "utilisateur")
    private List<Ticket> tickets;

    @OneToMany(mappedBy = "utilisateur")
    private List<Notification> notifications;

}
