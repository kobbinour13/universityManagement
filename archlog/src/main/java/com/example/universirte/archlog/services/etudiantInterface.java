package com.example.universirte.archlog.services;

import com.example.universirte.archlog.entities.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import java.util.List;
import java.util.Optional;

public interface etudiantInterface {
    void saveEtudiant(Etudiant Etu);
    void UpdateEtudiant(Etudiant Ens);
    List<Etudiant>ListEtudiant();
    void removeEtudiant(Long Id);
    public Optional<Etudiant> findEtudiant(Long Id);
}
