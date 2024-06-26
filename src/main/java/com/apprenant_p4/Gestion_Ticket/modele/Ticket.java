package com.apprenant_p4.Gestion_Ticket.modele;

import com.apprenant_p4.Gestion_Ticket.modele.Enum.Priorites;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "ticket")

public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String description;
    private String categorie;
    @Enumerated(EnumType.STRING)
    private Priorites priorite;
    private Boolean estRepondu;
    private String reponse;

    private LocalDateTime dateCreation;
    @PrePersist
    protected  void onCreate(){
        dateCreation = LocalDateTime.now();
    }

    @OneToMany(mappedBy = "ticket")
    private List<Notification> notificationList;


    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Utilisateur utilisateur;
}
