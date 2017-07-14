package com.vkkzlabs.controller;

import com.vkkzlabs.entity.TypeOfAcceptWork;
import com.vkkzlabs.service.TypeOfAcceptWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("TypeOfAcceptWork")
public class TypeOfAcceptWorkController {
    @Autowired
    private TypeOfAcceptWorkService typeOfAcceptWorkService;

    @GetMapping("{id}")
    public ResponseEntity<TypeOfAcceptWork> getTypeOfAcceptWorkById(@PathVariable("id") Integer id) {
        TypeOfAcceptWork typeOfAcceptWork = typeOfAcceptWorkService.getTypeOfAcceptWorkByIdAcceptWork(id);
        if (typeOfAcceptWork != null) {
            return new ResponseEntity<TypeOfAcceptWork>(typeOfAcceptWork, HttpStatus.OK);
        } return new ResponseEntity<TypeOfAcceptWork>(HttpStatus.NOT_FOUND);
    }
}
