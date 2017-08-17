package com.vkkzlabs.impl.controller;

import com.vkkzlabs.api.entity.Answer;
import com.vkkzlabs.api.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Класс предназначен для мапинга ответов студента на контрольный тест
 */

@Controller
@RequestMapping("Answer")
public class AnswerController {
    @Autowired
    private AnswerService answerService;

    @GetMapping("{id}")
    public ResponseEntity<Answer> getAnswerById(@PathVariable("id") Integer id) {
        Answer answer = answerService.getAnswerByIdAnswer(id);
        if (answer != null) {
            return new ResponseEntity<Answer>(answer, HttpStatus.OK);
        } return new ResponseEntity<Answer>(HttpStatus.NOT_FOUND);
    }
}
