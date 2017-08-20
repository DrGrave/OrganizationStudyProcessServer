package com.vkkzlabs.impl.controller;

import com.vkkzlabs.api.entity.TypeOfQuestion;
import com.vkkzlabs.api.service.TypeOfQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *  Преднозначен для работы с типами вопросов
 */

@Controller
@RequestMapping("TypeOfQuestion")
public class TypeOfQuestionController {
    @Autowired
    private TypeOfQuestionService typeOfQuestionService;

    @GetMapping("{id}")
    public ResponseEntity<TypeOfQuestion> getTypeofQuestionById(@PathVariable("id") Integer id) {
        TypeOfQuestion typeOfQuestion = typeOfQuestionService.getTypeOfQuestionByIdTypeOfQuestion(id);
        if (typeOfQuestion != null) {
            return new ResponseEntity<TypeOfQuestion>(typeOfQuestion, HttpStatus.OK);
        } return new ResponseEntity<TypeOfQuestion>(HttpStatus.NOT_FOUND);
    }
}
