package com.vkkzlabs.controller;

import com.vkkzlabs.entity.M2MStudentWork;
import com.vkkzlabs.service.StudentWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("StudentWork")
public class StudentWorkController {
    @Autowired
    private StudentWorkService studentWorkService;

    @GetMapping("{id}")
    public ResponseEntity<M2MStudentWork> getStudentWorkById(@PathVariable("id") Integer id) {
        M2MStudentWork studentWork = studentWorkService.getStudentWorkByIdStudentWork(id);
        if (studentWork != null) {
            return new ResponseEntity<M2MStudentWork>(studentWork, HttpStatus.OK);
        } return new ResponseEntity<M2MStudentWork>(HttpStatus.NOT_FOUND);
    }
}
