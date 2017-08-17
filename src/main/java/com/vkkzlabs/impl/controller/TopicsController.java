package com.vkkzlabs.impl.controller;

import com.vkkzlabs.api.entity.Topics;
import com.vkkzlabs.api.service.TopicsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("Topic")
public class TopicsController {
    @Autowired
    private TopicsService topicsService;

    @GetMapping("{id}")
    public ResponseEntity<Topics> getTopicById(@PathVariable("id") Integer id) {
        Topics topics = topicsService.getTopicByIdTopic(id);
        if (topics != null) {
            return new ResponseEntity<Topics>(topics, HttpStatus.OK);
        } return new ResponseEntity<Topics>(HttpStatus.NOT_FOUND);
    }
}
