package com.example.universirte.archlog.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
@AllArgsConstructor
@Getter
@Setter
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
    public Etudiant(){
    }

    @ManyToMany(mappedBy = "etudiants")
    private List<Cours> listCours;

    @ManyToMany (mappedBy = "ListEtudiant")
    private List<Enseignant> listEnseignant;
}
