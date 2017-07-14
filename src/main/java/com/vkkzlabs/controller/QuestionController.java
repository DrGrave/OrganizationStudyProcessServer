package com.vkkzlabs.controller;

import com.vkkzlabs.entity.Question;
import com.vkkzlabs.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("Question")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @GetMapping("{id}")
    public ResponseEntity<Question> getQuestionById(@PathVariable("id") Integer id) {
        Question question = questionService.getQuestionByIdQuestion(id);
        if (question != null) {
            return new ResponseEntity<Question>(question, HttpStatus.OK);
        } return new ResponseEntity<Question>(HttpStatus.NOT_FOUND);
    }
}
