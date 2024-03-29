package com.vkkzlabs.impl.controller;

import com.vkkzlabs.api.entity.Question;
import com.vkkzlabs.api.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *  Данный класс предназначен для мапинга запросов связанных с контрольными вопросами
 */

@Controller
@RequestMapping("Question")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    /**
     * по запросу /Question/{id} возвращает объект по его Id
     */

    @GetMapping("{id}")
    public ResponseEntity<Question> getQuestionById(@PathVariable("id") Integer id) {
        Question question = questionService.getQuestionByIdQuestion(id);
        if (question != null) {
            return new ResponseEntity<Question>(question, HttpStatus.OK);
        } return new ResponseEntity<Question>(HttpStatus.NOT_FOUND);
    }
}
