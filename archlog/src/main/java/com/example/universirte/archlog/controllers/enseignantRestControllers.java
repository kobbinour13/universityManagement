package com.example.universirte.archlog.controllers;

import com.example.universirte.archlog.entities.Enseignant;
import com.example.universirte.archlog.services.enseignantInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")

@RestController
@RequestMapping(value = "/Enseignants",method = {RequestMethod.GET})
public class enseignantRestControllers {
    @Autowired
    enseignantInterface enseignantService;

    @PostMapping("/CreateEnseignant")
    public Enseignant createEnseignant(@Validated @RequestBody Enseignant enseignant) {
        enseignantService.saveens(enseignant);
        return enseignant;
    }

    @GetMapping("/getAllEnseignant")
    public List<Enseignant> getAllEnseignant(){
        return enseignantService.Listde();
    }
    @GetMapping("/findEnseignant/{id}")
    public Optional<Enseignant> findEnseignant(@PathVariable String id)
    {
        return enseignantService.findens(Long.parseLong(id));

    }
    @PutMapping("/UpdateEnseignant")
    public String UpdateEnseignant(@PathVariable(value="id") Long medid,@Validated @RequestBody Enseignant enseignant)
    { enseignantService.Updateens(enseignant);

        return"success:Update a ete bien faite";

    }
}
