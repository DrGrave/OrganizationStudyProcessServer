package com.vkkzlabs.controller;

import com.vkkzlabs.entity.Answer;
import com.vkkzlabs.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("Answer")
public class AnswerController {
    @Autowired
    private AnswerService answerService;

    @GetMapping("{id}")
    public ResponseEntity<Answer> getAnswerById(@PathVariable("id") Integer id) {
        Answer article = answerService.getAnswerByIdAnswer(id);
        System.out.print(article);
        return new ResponseEntity<Answer>(article, HttpStatus.OK);
    }
}