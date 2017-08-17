package com.vkkzlabs.impl.controller;

import com.vkkzlabs.api.entity.SupportingDataForWork;
import com.vkkzlabs.api.service.SupportingDataForWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("SupportingDataForWork")
public class SupportingDataForWorkController {
    @Autowired
    SupportingDataForWorkService supportingDataForWorkService;

    @GetMapping("{id}")
    public ResponseEntity<SupportingDataForWork> getSupportingDataForWorkById(@PathVariable("id") Integer id) {
        SupportingDataForWork supportingDataForWork = supportingDataForWorkService.getSupportingDataForWorkById(id);
        if (supportingDataForWork != null) {
            return new ResponseEntity<SupportingDataForWork>(supportingDataForWork, HttpStatus.OK);
        } return new ResponseEntity<SupportingDataForWork>(HttpStatus.NOT_FOUND);
    }
}
