package com.example.universirte.archlog.entities;

import javax.persistence.*;
import java.io.Serializable;
@Entity
public class Salle implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long numS;
    private String nomS;
    private int capacite;

    @OneToOne(mappedBy = "salleName")
    private Cours cours_salle;
}
