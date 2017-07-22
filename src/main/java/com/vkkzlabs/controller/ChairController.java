package com.vkkzlabs.controller;

import com.vkkzlabs.entity.Chair;
import com.vkkzlabs.service.ChairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("Chair")
public class ChairController {
    @Autowired
    private ChairService chairService;

    @GetMapping("{id}")
    public ResponseEntity<Chair> getChairById(@PathVariable("id") Integer id) {
        Chair chair = chairService.getChairById(id);
        if (chair != null) {
            return new ResponseEntity<Chair>(chair, HttpStatus.OK);
        } return new ResponseEntity<Chair>(HttpStatus.NOT_FOUND);
    }

}