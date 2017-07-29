package com.vkkzlabs.controller;

import com.vkkzlabs.entity.M2MStudentWork;
import com.vkkzlabs.entity.Subject;
import com.vkkzlabs.service.StudentWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

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

    @GetMapping(value = "/subject/toStudentWorks/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<M2MStudentWork>> getSubjectsToStudent(@PathVariable("id") int id) {
        List<M2MStudentWork> subjectList = studentWorkService.getListSubjectsToStudent(id);
        if (subjectList == null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<List<M2MStudentWork>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<M2MStudentWork>>(subjectList, HttpStatus.OK);
    }

    @GetMapping(value = "/User/{idUser}/Subject/{idSubject}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<M2MStudentWork>> getWorkToStudent(@PathVariable("idUser") int idUser, @PathVariable("idSubject") int idSubject) {
        List<M2MStudentWork> subjectList = studentWorkService.getListWorksToStudent(idUser, idSubject);
        if (subjectList == null) {
            System.out.println("works with id " + idUser + " not found");
            return new ResponseEntity<List<M2MStudentWork>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<M2MStudentWork>>(subjectList, HttpStatus.OK);
    }
}
