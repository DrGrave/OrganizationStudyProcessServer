package com.vkkzlabs.controller;

import com.vkkzlabs.entity.TypeOfAttorney;
import com.vkkzlabs.service.TypeOfAttorneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("TypeOfAttorney")
public class TypeOfAttorneyController {
    @Autowired
    private TypeOfAttorneyService typeOfAttorneyService;

    @GetMapping("{id}")
    public ResponseEntity<TypeOfAttorney> getTypeOfAttorneyById(@PathVariable("id") Integer id) {
        TypeOfAttorney typeOfAttorney = typeOfAttorneyService.getTypeOfAttorneyByIdTypeOfAttorney(id);
        if (typeOfAttorney != null) {
            return new ResponseEntity<TypeOfAttorney>(typeOfAttorney, HttpStatus.OK);
        } return new ResponseEntity<TypeOfAttorney>(HttpStatus.NOT_FOUND);
    }
}
