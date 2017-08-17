package com.vkkzlabs.impl.controller;

import com.vkkzlabs.api.entity.Faculty;
import com.vkkzlabs.api.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("Faculty")
public class FacultyController {
    @Autowired
    private FacultyService facultyService;

    @GetMapping("{id}")
    public ResponseEntity<Faculty> getFacultyById(@PathVariable("id") Integer id) {
        Faculty faculty = facultyService.getFacultyById(id);
        if (faculty != null) {
            return new ResponseEntity<Faculty>(faculty, HttpStatus.OK);
        } return new ResponseEntity<Faculty>(HttpStatus.NOT_FOUND);
    }

}



