package com.vkkzlabs.impl.controller;

import com.vkkzlabs.api.entity.Timetable;
import com.vkkzlabs.api.service.TimetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
