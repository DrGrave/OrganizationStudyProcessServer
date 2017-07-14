package com.vkkzlabs.controller;

import com.vkkzlabs.entity.StudentGroup;
import com.vkkzlabs.service.StudentGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("Group")
public class StudentGroupController {
    @Autowired
    private StudentGroupService studentGroupService;

    @GetMapping("{id}")
    public ResponseEntity<StudentGroup> getStudentGroupById(@PathVariable("id") Integer id) {
        StudentGroup studentGroup = studentGroupService.getStudentGroupByIdStudentGroup(id);
        if (studentGroup != null) {
            return new ResponseEntity<StudentGroup>(studentGroup, HttpStatus.OK);
        } return new ResponseEntity<StudentGroup>(HttpStatus.NOT_FOUND);
    }
}
