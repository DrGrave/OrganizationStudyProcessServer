package com.vkkzlabs.controller;

import com.vkkzlabs.entity.Queue;
import com.vkkzlabs.service.QueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("Queue")
public class QueueController {
    @Autowired
    private QueueService queueService;

    @GetMapping("{id}")
    public ResponseEntity<Queue> getQueueById(@PathVariable("id") Integer id) {
        Queue queue = queueService.getQueueByIdQueue(id);
        if (queue != null) {
            return new ResponseEntity<Queue>(queue, HttpStatus.OK);
        } return new ResponseEntity<Queue>(HttpStatus.NOT_FOUND);
    }
}
