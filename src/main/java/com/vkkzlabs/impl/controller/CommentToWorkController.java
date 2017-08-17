package com.vkkzlabs.impl.controller;

import com.vkkzlabs.api.entity.CommentToWork;
import com.vkkzlabs.api.service.CommentToWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Класс предназначен для маппинга запросов связанных с комментариями на работу студента
 */

@Controller
@RequestMapping("CommentToWork")
public class CommentToWorkController {
    @Autowired
    private CommentToWorkService commentToWorkService;

    @GetMapping("{id}")
    public ResponseEntity<CommentToWork> getCommentToWork(@PathVariable("id") Integer id) {
        CommentToWork commentToWork = commentToWorkService.getCommentToWorkByIdCommentToWork(id);
        if (commentToWork != null) {
            return new ResponseEntity<CommentToWork>(commentToWork, HttpStatus.OK);
        }return new ResponseEntity<CommentToWork>(HttpStatus.NOT_FOUND);
    }
}
