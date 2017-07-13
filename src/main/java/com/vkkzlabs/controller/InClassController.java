package com.vkkzlabs.controller;

import com.vkkzlabs.entity.InClass;
import com.vkkzlabs.service.InClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("InClass")
public class InClassController {
    @Autowired
    private InClassService inClassService;
    @GetMapping("{id}")
    public ResponseEntity<InClass> getCommentToWork(@PathVariable("id") Integer id) {
        InClass inClass = inClassService.getInClassByIdInClass(id);
        if (inClass != null) {
            return new ResponseEntity<InClass>(inClass, HttpStatus.OK);
        }else {
            return new ResponseEntity<InClass>(HttpStatus.NOT_FOUND);
        }
    }

}