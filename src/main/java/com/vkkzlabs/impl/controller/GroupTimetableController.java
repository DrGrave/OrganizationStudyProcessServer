package com.vkkzlabs.impl.controller;

import com.vkkzlabs.api.entity.M2MGroupTimetable;
import com.vkkzlabs.api.service.GroupTimetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *  Данный класс предназначен для мапинга запросов связанных с расписанием группы
 */

@Controller
@RequestMapping("GroupTimetable")
public class GroupTimetableController {
    @Autowired
    private GroupTimetableService groupTimetableService;

    @GetMapping("{id}")
    public ResponseEntity<M2MGroupTimetable> getGroupTimetableById(@PathVariable("id") Integer id) {
        M2MGroupTimetable groupTimetable = groupTimetableService.getGroupTimetableByIdGroupTimetable(id);
        if (groupTimetable != null) {
            return new ResponseEntity<M2MGroupTimetable>(groupTimetable, HttpStatus.OK);
        } return new ResponseEntity<M2MGroupTimetable>(HttpStatus.NOT_FOUND);
    }
}
