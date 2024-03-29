package com.vkkzlabs.impl.controller;

import com.vkkzlabs.api.entity.StudentGroup;
import com.vkkzlabs.api.service.StudentGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 *  Данный класс предназначен для мапинга запросов связанных с группой студента
 */

@Controller
@RequestMapping("Group")
public class StudentGroupController {
    @Autowired
    private StudentGroupService studentGroupService;

    /**
     * по запросу /Group/{id} возвращает объект по его Id
     */

    @GetMapping("{id}")
    public ResponseEntity<StudentGroup> getStudentGroupById(@PathVariable("id") Integer id) {
        StudentGroup studentGroup = studentGroupService.getStudentGroupByIdStudentGroup(id);
        if (studentGroup != null) {
            return new ResponseEntity<StudentGroup>(studentGroup, HttpStatus.OK);
        } return new ResponseEntity<StudentGroup>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("GetGroupsToProfessor/{idUser}")
    public ResponseEntity<List<StudentGroup>> getListStudentGroup(@PathVariable("idUser") int idProfessor){
        List<StudentGroup> studentGroups = studentGroupService.getListStudentGroupsToProfessor(idProfessor);
        if (studentGroups != null){
            return new ResponseEntity<List<StudentGroup>>(studentGroups,HttpStatus.OK);
        }return new ResponseEntity<List<StudentGroup>>(HttpStatus.NOT_FOUND);
    }
}
