package com.vkkzlabs.impl.controller;


import com.vkkzlabs.api.entity.TypeOfAnswer;
import com.vkkzlabs.api.service.TypeOfAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("TypeOfAnswer")
public class TypeOfAnswerController {
    @Autowired
    private TypeOfAnswerService typeOfAnswerService;

    @GetMapping("{id}")
    public ResponseEntity<TypeOfAnswer> getTypeOfAnswerById(@PathVariable("id") Integer id) {
        TypeOfAnswer typeOfAnswer = typeOfAnswerService.getTypeOfAnswerByIdTypeOfAnswer(id);
        if (typeOfAnswer != null) {
            return new ResponseEntity<TypeOfAnswer>(typeOfAnswer, HttpStatus.OK);
        } return new ResponseEntity<TypeOfAnswer>(HttpStatus.NOT_FOUND);
    }
}
