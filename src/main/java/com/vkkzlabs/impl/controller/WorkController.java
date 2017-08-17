package com.vkkzlabs.impl.controller;

import com.vkkzlabs.api.entity.Work;
import com.vkkzlabs.api.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *  Для работы с работами для студентов
 */

@Controller
@RequestMapping("Work")
public class WorkController {
    @Autowired
    private WorkService workService;

    @GetMapping("{id}")
    public ResponseEntity<Work> getWorkById(@PathVariable("id") Integer id) {
        Work work = workService.getWorkByIdWork(id);
        if (work != null) {
            return new ResponseEntity<Work>(work, HttpStatus.OK);
        } return new ResponseEntity<Work>(HttpStatus.NOT_FOUND);
    }
}
