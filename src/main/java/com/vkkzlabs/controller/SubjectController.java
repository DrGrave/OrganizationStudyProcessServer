package com.vkkzlabs.controller;

import com.vkkzlabs.entity.Subject;
import com.vkkzlabs.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("Subject")
public class SubjectController {
    @Autowired
    private SubjectService subjectService;

    @GetMapping("{id}")
    public ResponseEntity<Subject> getSubjectById(@PathVariable("id") Integer id) {
        Subject subject = subjectService.getSubjectByIdSubject(id);
        if (subject != null) {
            return new ResponseEntity<Subject>(subject, HttpStatus.OK);
        } return new ResponseEntity<Subject>(HttpStatus.NOT_FOUND);
    }
}
