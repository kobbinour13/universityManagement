package com.example.universirte.archlog.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
@Entity
public class Etudiant implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numInscription;
    private String nomETU;
    private String prenomETU;
    private String adresseETU;
    private Date dateentree;

    public Etudiant(String nomETU, String prenomETU, String adresseETU, Date dateentree) {
        this.nomETU = nomETU;
        this.prenomETU = prenomETU;
        this.adresseETU = adresseETU;
        this.dateentree = dateentree;
    }

    @ManyToMany(mappedBy = "etudiants")
    private List<Cours> listCours;

    @ManyToMany (mappedBy = "ListEtudiant")
    private List<Enseignant> listEnseignant;
}
