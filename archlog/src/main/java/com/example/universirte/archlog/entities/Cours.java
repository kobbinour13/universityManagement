package com.example.universirte.archlog.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;
@Entity
public class Cours implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codeC;
    private String libelleC;

    @OneToOne(cascade = CascadeType.ALL)
    private Salle salleName;

    public Cours(String libelleC, Salle salleName, List<Enseignant> enseignants, List<Etudiant> etudiants) {
        this.libelleC = libelleC;
        this.salleName = salleName;
        this.enseignants = enseignants;
        this.etudiants = etudiants;
    }

    public String getLibelleC() {
        return libelleC;
    }

    public Salle getSalleName() {
        return salleName;
    }

    public List<Enseignant> getEnseignants() {
        return enseignants;
    }

    public List<Etudiant> getEtudiants() {
        return etudiants;
    }

    @OneToMany (mappedBy="cours", cascade = CascadeType.ALL)
    private List<Enseignant> enseignants;

    @ManyToMany
    @JoinTable(
            name="cours_etudiant",
            joinColumns = @JoinColumn (name="etudiant_id"),
            inverseJoinColumns = @JoinColumn (name="cours_id"))
    private List<Etudiant> etudiants;
}
