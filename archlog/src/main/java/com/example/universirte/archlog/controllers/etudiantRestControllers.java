package com.example.universirte.archlog.controllers;

import com.example.universirte.archlog.entities.Etudiant;
import com.example.universirte.archlog.services.etudiantInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Etudiants")
public class etudiantRestControllers {
    @Autowired
    etudiantInterface etudiantInterface;
    @PostMapping("/createEtudiant")
    public Etudiant createEtudiant(@Validated @RequestBody Etudiant etudiant){
        etudiantInterface.saveEtudiant(etudiant);
        return etudiant;
    }
    @GetMapping("/all")
    public List<Etudiant> getAllEtudiant(){
        return etudiantInterface.ListEtudiant();
    }

}
