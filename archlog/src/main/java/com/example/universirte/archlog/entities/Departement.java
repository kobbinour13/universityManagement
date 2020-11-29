package com.example.universirte.archlog.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Departement implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codeDEP;



    @Column(name="nomDEP")
    private String nomDEP;

    @ManyToOne
    @JoinColumn (name="codeUNV", referencedColumnName="codeUNV")
    private University university;

    @OneToMany (mappedBy="departementEns")
    private List<Enseignant> enseignants;


    public Departement(String nomDEP, University university, List<Enseignant> enseignants) {
        this.nomDEP = nomDEP;
        this.university = university;
        this.enseignants = enseignants;
    }

    public Long getCodeDEP() {
        return codeDEP;
    }

    public String getNomDEP() {
        return nomDEP;
    }

    public University getUniversity() {
        return university;
    }

    public List<Enseignant> getEnseignants() {
        return enseignants;
    }
}
