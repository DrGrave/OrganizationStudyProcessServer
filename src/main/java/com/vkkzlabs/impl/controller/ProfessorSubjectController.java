package com.vkkzlabs.impl.controller;

import com.vkkzlabs.api.entity.M2MProfessorSubject;
import com.vkkzlabs.api.entity.Subject;
import com.vkkzlabs.api.service.ProfessorSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Данный класс предназначен для мапинга запросов связанных с преподавательскими предметами
 */

@Controller
@RequestMapping("ProfessorSubject")
public class ProfessorSubjectController {
    @Autowired
    private ProfessorSubjectService professorSubjectService;

    /**
     * по запросу /ProfessorSubject/{id} возвращает объект по его Id
     */

    @GetMapping("{id}")
    public ResponseEntity<M2MProfessorSubject> getProfessorSubjectById(@PathVariable("id") Integer id) {
        M2MProfessorSubject professorSubject = professorSubjectService.getProfessorSubjectByIdProfessorSubject(id);
        if (professorSubject != null) {
            return new ResponseEntity<M2MProfessorSubject>(professorSubject, HttpStatus.OK);
        } return new ResponseEntity<M2MProfessorSubject>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("GetSubjects/{id}")
    public ResponseEntity<List<Subject>> getSubjectsToProfessor(@PathVariable("id") Integer id){
        List<Subject> subjectList = professorSubjectService.getAllSubjects(id);
        if (subjectList != null){
            return new ResponseEntity<List<Subject>>(subjectList, HttpStatus.OK);
        }return new ResponseEntity<List<Subject>>(HttpStatus.NOT_FOUND);
    }
}
