package com.example.universirte.archlog.controllers;

import com.example.universirte.archlog.entities.Departement;
import com.example.universirte.archlog.services.departementInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/Department",method = {RequestMethod.GET})
public class departementRestControllers {
    @Autowired
    departementInterface departementService;

    @PostMapping("/CreateSalle")
    public Departement createsalle(@Validated @RequestBody Departement dept) {
        departementService.savedepartement(dept);
        return dept;
    }

    @GetMapping("/getAllDepartements")
    public List<Departement> getAlldepartements(){
        return departementService.Listde();
    }

    @GetMapping("/findDepartement/{id}")
    public Optional<Departement> findDepartement(@PathVariable String id)
    {
        return departementService.findDepartement(Long.parseLong(id));

    }
    @PutMapping("/UpdateDepartement")
    public String UpdateDepartement(@PathVariable(value="id") Long medid, @Validated @RequestBody Departement dept)
    { departementService.Updatedepartement(dept);

        return"success:Update a ete bien faite";

    }

    @DeleteMapping(value="/deleteDepartement/{id}")
    public String deleteDepartement(@PathVariable String id)
    {
        departementService.removeDepartement(Long.parseLong(id));
        return "ok!";
    }
}
