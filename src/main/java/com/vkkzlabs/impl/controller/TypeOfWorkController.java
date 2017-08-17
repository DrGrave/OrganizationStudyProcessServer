package com.vkkzlabs.impl.controller;

import com.vkkzlabs.api.entity.TypeOfWork;
import com.vkkzlabs.api.service.TypeOfWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("TypeOfWork")
public class TypeOfWorkController {
    @Autowired
    private TypeOfWorkService typeOfWorkService;

    @GetMapping("{id}")
    public ResponseEntity<TypeOfWork> getTypeOfWorkById(@PathVariable("id") Integer id) {
        TypeOfWork typeOfWork = typeOfWorkService.getTypeOfWorkByIdTypeOfWork(id);
        if (typeOfWork != null) {
            return new ResponseEntity<TypeOfWork>(typeOfWork, HttpStatus.OK);
        } return new ResponseEntity<TypeOfWork>(HttpStatus.NOT_FOUND);
    }
}
