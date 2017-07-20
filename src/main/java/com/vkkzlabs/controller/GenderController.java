package com.vkkzlabs.controller;

import com.vkkzlabs.entity.Gender;
import com.vkkzlabs.service.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("Gender")
public class GenderController {
    @Autowired
    private GenderService genderService;

    @GetMapping("{id}")
    public ResponseEntity<Gender> getGenderById(@PathVariable("id") Integer id) {
        Gender gender = genderService.getGenderById(id);
        if (gender != null) {
            return new ResponseEntity<Gender>(gender, HttpStatus.OK);
        } return new ResponseEntity<Gender>(HttpStatus.NOT_FOUND);
    }
}
