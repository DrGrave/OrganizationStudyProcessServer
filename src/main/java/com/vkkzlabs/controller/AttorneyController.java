package com.vkkzlabs.controller;

import com.vkkzlabs.entity.Attorney;
import com.vkkzlabs.service.AttorneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("attorney")
public class AttorneyController {
    @Autowired
    private AttorneyService attorneyService;

    @GetMapping("{id}")
    public ResponseEntity<Attorney> getAttorneyById(@PathVariable("id") Integer id) {
        Attorney attorney = attorneyService.getAttorneyByIdAttorney(id);
        if (attorney != null) {
            return new ResponseEntity<Attorney>(attorney, HttpStatus.OK);
        } else {
            return new ResponseEntity<Attorney>(HttpStatus.NOT_FOUND);
        }
    }

}
