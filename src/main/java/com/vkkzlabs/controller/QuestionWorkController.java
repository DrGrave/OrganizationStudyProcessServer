package com.vkkzlabs.controller;


import com.vkkzlabs.entity.M2MQuestionWork;
import com.vkkzlabs.service.QuestionWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("QuestionWork")
public class QuestionWorkController {
    @Autowired
    private QuestionWorkService questionWorkService;

    @GetMapping("{id}")
    public ResponseEntity<M2MQuestionWork> getQuestionWorkById(@PathVariable("id") Integer id) {
        M2MQuestionWork questionWork = questionWorkService.getQuestionWorkByIdQuestionWork(id);
        if (questionWork != null) {
            return new ResponseEntity<M2MQuestionWork>(questionWork, HttpStatus.OK);
        } return new ResponseEntity<M2MQuestionWork>(HttpStatus.NOT_FOUND);
    }
}
