package com.example.universirte.archlog.controllers;

import com.example.universirte.archlog.entities.Cours;
import com.example.universirte.archlog.services.coursInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/Cours",method = {RequestMethod.GET})
public class coursRestControllers {
    @Autowired
    coursInterface coursService;

    @PostMapping("/CreateCours")
    public Cours createCours(@Validated @RequestBody Cours cours) {
        coursService.saveCours(cours);
        return cours;
    }

    @GetMapping("/getAllCours")
    public List<Cours> getAllCours(){
        return coursService.ListCours();
    }
    @GetMapping("/findCours/{id}")
    public Optional<Cours> findCours(@PathVariable String id)
    {
        return coursService.findCours(Long.parseLong(id));

    }
    @PutMapping("/UpdateCours")
    public String UpdateEtudiant(@PathVariable(value="id") Long medid,@Validated @RequestBody Cours cours)
    { coursService.UpdateCours(cours);

        return"success:Update a ete bien faite";


    }
    @DeleteMapping(value="/deleteCours/{id}")
    public String deleteCours(@PathVariable String id)
    {
        coursService.removeCours(Long.parseLong(id));
        return "ok!";
    }

}
