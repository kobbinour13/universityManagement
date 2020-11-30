package com.example.universirte.archlog.controllers;

import com.example.universirte.archlog.entities.Etudiant;
import com.example.universirte.archlog.services.etudiantInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/Etudiants",method= {RequestMethod.GET})
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
    @GetMapping("/findEtudiant/{id}")
    public Optional<Etudiant> findEtudiant(@PathVariable String id)
    {
        return etudiantInterface.findEtudiant(Long.parseLong(id));

    }
    @PutMapping("/UpdateEtudiant")
    public String UpdateEtudiant(@PathVariable(value="id") Long medid,@Validated @RequestBody Etudiant etudiant1)
    { etudiantInterface.UpdateEtudiant(etudiant1);

        return"success:Update a ete bien faite";

    }
    @DeleteMapping(value="/deleteEtudiant/{id}")
    public String deleteEtudiant(@PathVariable String id)
    {
        etudiantInterface.removeEtudiant(Long.parseLong(id));
        return "ok!";
    }

}
