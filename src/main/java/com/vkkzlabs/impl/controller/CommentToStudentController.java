package com.vkkzlabs.impl.controller;

import com.vkkzlabs.api.entity.CommentToStudent;
import com.vkkzlabs.api.service.CommentToStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *  Класс предназначен для мапинга запросов связанных с комментариями на студента.
 */

@Controller
@RequestMapping("CommentToStudent")
public class CommentToStudentController {
    @Autowired
    private CommentToStudentService commentToStudentService;

    @GetMapping("{id}")
    public ResponseEntity<CommentToStudent> getCommentToStudentById(@PathVariable("id") Integer id) {
        CommentToStudent attorney = commentToStudentService.getCommentToStudentByIdCommentToStudent(id);
        if (attorney != null) {
            return new ResponseEntity<CommentToStudent>(attorney, HttpStatus.OK);
        }return new ResponseEntity<CommentToStudent>(HttpStatus.NOT_FOUND);

    }
}
