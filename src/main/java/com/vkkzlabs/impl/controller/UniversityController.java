package com.vkkzlabs.impl.controller;

import com.vkkzlabs.api.entity.University;
import com.vkkzlabs.api.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("University")
public class UniversityController {
    @Autowired
    private UniversityService universityService;

    @GetMapping("{id}")
    public ResponseEntity<University> getUniversityById(@PathVariable("id") Integer id) {
        University university = universityService.getUniversityById(id);
        if (university != null) {
            return new ResponseEntity<University>(university, HttpStatus.OK);
        } return new ResponseEntity<University>(HttpStatus.NOT_FOUND);
    }
}
