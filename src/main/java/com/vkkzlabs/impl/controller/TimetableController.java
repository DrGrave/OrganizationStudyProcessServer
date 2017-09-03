package com.vkkzlabs.impl.controller;

import com.vkkzlabs.api.entity.Timetable;
import com.vkkzlabs.api.service.TimetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

/**
 *  Данный класс предназначен для мапинга запросов связанных с расписанием пар
 */

@Controller
@RequestMapping("Timetable")
public class TimetableController {
    @Autowired
    private TimetableService timetableService;

    @GetMapping("{id}")
    public ResponseEntity<Timetable> getTimetableById(@PathVariable("id") Integer id) {
        Timetable timetable = timetableService.getTimetableByIdTimetable(id);
        if (timetable != null) {
            return new ResponseEntity<Timetable>(timetable, HttpStatus.OK);
        } return new ResponseEntity<Timetable>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("GetToStudent/IdProfessor/{professorId}/IdSubject/{subjectId}")
    public ResponseEntity<Timetable> getTimetableByIdProfessorAndIdSubjectToAddQueue(@PathVariable("professorId") int professorId, @PathVariable("subjectId") int subjectId){
        Timetable timetable = timetableService.getTimetableByProfessorIdAndSubjectId(professorId, subjectId);
        if (timetable != null){
            return new ResponseEntity<Timetable>(timetable, HttpStatus.OK);
        } return new ResponseEntity<Timetable>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("Save")
    public  ResponseEntity<Timetable> getListToQueue(@RequestBody Timetable timetable, UriComponentsBuilder uriComponentsBuilder){
            timetableService.saveTimetable(timetable);
            if (timetable != null) {
                return new ResponseEntity<Timetable>(timetable, HttpStatus.OK);
            } return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("GetAllTimetable/{id}")
    public  ResponseEntity<List<Timetable>> getAllTimetableToProfessor(@PathVariable("id") int idUser){
        List<Timetable> timetableList = timetableService.getAllTimetableToUser(idUser);
        if (timetableList != null){
            return new ResponseEntity<List<Timetable>>(timetableList, HttpStatus.OK);
        } return new ResponseEntity<List<Timetable>>(HttpStatus.NOT_FOUND);
    }

}
