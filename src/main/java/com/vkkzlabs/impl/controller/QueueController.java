package com.vkkzlabs.impl.controller;

import com.vkkzlabs.api.entity.MyUser;
import com.vkkzlabs.api.entity.MyUserCredentials;
import com.vkkzlabs.api.entity.Queue;
import com.vkkzlabs.api.service.QueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 *  Данный класс предназначен для работы с очередью студентов
 */

@Controller
@RequestMapping("Queue")
public class QueueController {
    @Autowired
    private QueueService queueService;

    /**
     * по запросу /Queue/{id} возвращает объект по его Id
     */

    @GetMapping("{id}")
    public ResponseEntity<Queue> getQueueById(@PathVariable("id") Integer id) {
        Queue queue = queueService.getQueueByIdQueue(id);
        if (queue != null) {
            return new ResponseEntity<Queue>(queue, HttpStatus.OK);
        } return new ResponseEntity<Queue>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("StayInQueue")
    public  ResponseEntity<List<Queue>> getListToQueue(@RequestBody Queue queue, UriComponentsBuilder uriComponentsBuilder){
        queueService.saveQueue(queue);
        List<Queue> queues = queueService.getAllQueueToStudent(queue);
        if (queues != null) {
            return new ResponseEntity<List<Queue>>(queues, HttpStatus.OK);
        } return new ResponseEntity<List<Queue>>(HttpStatus.NOT_FOUND);
    }

}
