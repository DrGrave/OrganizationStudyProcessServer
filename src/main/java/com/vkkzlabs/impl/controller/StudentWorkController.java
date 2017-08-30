package com.vkkzlabs.impl.controller;

import com.vkkzlabs.api.entity.M2MStudentWork;
import com.vkkzlabs.api.service.StudentWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import java.util.List;

/** Класс предназначен для мапинга запросов по работам студента
 * **/

@Controller
@RequestMapping("StudentWork")
public class StudentWorkController {
    @Autowired
    private StudentWorkService studentWorkService;

    /**
     * по запросу /StudentWork/{id} возвращает объект по его Id
     */

    @GetMapping("{id}")
    public ResponseEntity<M2MStudentWork> getStudentWorkById(@PathVariable("id") Integer id) {
        M2MStudentWork studentWork = studentWorkService.getStudentWorkByIdStudentWork(id);
        if (studentWork != null) {
            return new ResponseEntity<M2MStudentWork>(studentWork, HttpStatus.OK);
        } return new ResponseEntity<M2MStudentWork>(HttpStatus.NOT_FOUND);
    }

    /**
     * по запросу /StudentWork/ToStudentWork/{Id} возвращает объект по его Id
     */

    @GetMapping("/Subject/ToStudentWorks/{id}")
    public ResponseEntity<List<M2MStudentWork>> getSubjectsToStudent(@PathVariable("id") int id) {
        List<M2MStudentWork> subjectList = studentWorkService.getListSubjectsToStudent(id);
        if (subjectList == null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<List<M2MStudentWork>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<M2MStudentWork>>(subjectList, HttpStatus.OK);
    }

    /**
     * по запросу /StudentWork/User/{idUser}/Subject/{idSubject} возвращает объект по id пользователя и id предмета
     */

    @GetMapping("/User/{idUser}/Subject/{idSubject}")
    public ResponseEntity<List<M2MStudentWork>> getWorkToStudent(@PathVariable("idUser") int idUser, @PathVariable("idSubject") int idSubject) {
        List<M2MStudentWork> subjectList = studentWorkService.getListWorksToStudent(idUser, idSubject);
        if (subjectList == null) {
            System.out.println("works with id " + idUser + " not found");
            return new ResponseEntity<List<M2MStudentWork>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<M2MStudentWork>>(subjectList, HttpStatus.OK);
    }

    /**
     * по запросу /StudentWork/Student/Works/{id} возвращает объект по id пользователя
     */

    @GetMapping("Student/Works/{id}")
    public ResponseEntity<List<M2MStudentWork>> getAllWorks(@PathVariable("id") int id) {
        List<M2MStudentWork> subjectList = studentWorkService.getListSubjectsToStudent(id);
        if (subjectList == null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<List<M2MStudentWork>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<M2MStudentWork>>(subjectList, HttpStatus.OK);
    }

    @GetMapping("GetAccepted/{idUser}/Subject/{idSubject}")
    public ResponseEntity<List<M2MStudentWork>> getAcceptedWorkToStudentByIdUserAndIdSubject(@PathVariable("idUser") int idUser, @PathVariable("idSubject") int idSubject){
        List<M2MStudentWork> studentWorkList = studentWorkService.getListOfAcceptedStudentWorks(idUser, idSubject);
        if (studentWorkList != null){
            return new ResponseEntity<List<M2MStudentWork>>(studentWorkList, HttpStatus.OK);
        }return new ResponseEntity<List<M2MStudentWork>>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "Edit", method = RequestMethod.POST)
    public ResponseEntity editSetting(@RequestBody M2MStudentWork m2MStudentWork, UriComponentsBuilder ucBuilder) {
        studentWorkService.editStudentWork(m2MStudentWork);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping("/GetNewWorks/{id}")
    public ResponseEntity<List<M2MStudentWork>> getAllNewWork(@PathVariable("id") int id){
        List<M2MStudentWork> studentWorks = studentWorkService.getListOfNewWorks(id);
        return new ResponseEntity<List<M2MStudentWork>>(studentWorks, HttpStatus.OK);
    }
}
