package com.example.controllers;

import com.example.model.TypeLogement;
import com.example.repository.TypeLogementRepository;
import com.example.services.TypeLogementService;
import com.example.services.coverter.TypeLogementConverter;
import com.example.services.dto.TypeLogementDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TypeLogementController {
    @Autowired
    private TypeLogementRepository typeLogementRepository;

    @Autowired
    private TypeLogementService typeLogementService;

    @Autowired
    private TypeLogementConverter typeLogementConverter;

    @RequestMapping(value = "/api/typeLogements")
    public List<TypeLogement> getAllTypeLogements() {
        return typeLogementRepository.findAll();
    }

    @RequestMapping(value = "/api/typeLogement/{id}")
    public TypeLogement getTypeLogementById(@PathVariable("id") Integer id) {
        return typeLogementConverter.dtoToEntity(typeLogementService.findOneById(id));
    }

    @RequestMapping(value = "/api/typeLogement/delete/{id}")
    public void deleteTypeLogementById(@PathVariable("id") Integer id) {
        typeLogementRepository.deleteById(id);
    }

    @RequestMapping(value = "/api/typeLogement/create")
    public void createTypeLogement(@Param("libelle") String libelle) {
        if(typeLogementRepository.findByLibelle(libelle) == null && libelle != null) {
            TypeLogementDTO typeLogementDTO = new TypeLogementDTO();
            typeLogementDTO.setLibelle(libelle);
            typeLogementService.create(typeLogementDTO);
        }
    }
}
