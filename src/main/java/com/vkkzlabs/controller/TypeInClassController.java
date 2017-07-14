package com.vkkzlabs.controller;

import com.vkkzlabs.entity.TypeInClass;
import com.vkkzlabs.service.TypeInClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("TypeInClass")
public class TypeInClassController {
    @Autowired
    private TypeInClassService typeInClassService;

    @GetMapping("{id}")
    public ResponseEntity<TypeInClass> getTypeInClassById(@PathVariable("id") Integer id) {
        TypeInClass typeInClass = typeInClassService.getTypeInClassByIdTypeInClass(id);
        if (typeInClass != null) {
            return new ResponseEntity<TypeInClass>(typeInClass, HttpStatus.OK);
        } return new ResponseEntity<TypeInClass>(HttpStatus.NOT_FOUND);
    }
}
