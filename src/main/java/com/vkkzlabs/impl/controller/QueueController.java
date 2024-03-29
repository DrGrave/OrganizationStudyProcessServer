package com.vkkzlabs.impl.controller;

import com.vkkzlabs.api.entity.MyUser;
import com.vkkzlabs.api.entity.MyUserCredentials;
import com.vkkzlabs.api.entity.Queue;
import com.vkkzlabs.api.entity.Work;
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
        if (queueService.checkIfExists(queue)){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }else {
            queueService.saveQueue(queue);
            List<Queue> queues = queueService.getAllQueueToStudent(queue.getTimetable().getIdTimetable());
            if (queues != null) {
                return new ResponseEntity<List<Queue>>(queues, HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("GetByTimetable/{idTimetable}")
    public ResponseEntity<List<Queue>> getToStudentQueue(@PathVariable("idTimetable") int idTimetable){
        List<Queue> queues = queueService.getAllQueueToStudent(idTimetable);
        if (queues != null) {
            return new ResponseEntity<List<Queue>>(queues, HttpStatus.OK);
        } return new ResponseEntity<List<Queue>>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("GetSubjects/{idUser}/Timetable/{idTimetable}")
    public ResponseEntity<List<Queue>> getToStudentSubjects(@PathVariable("idTimetable") int idTimetable, @PathVariable("idUser") int idStudent){
        List<Queue> queues = queueService.getQueueToSubject(idTimetable, idStudent);
        if (queues != null) {
            return new ResponseEntity<List<Queue>>(queues, HttpStatus.OK);
        } return new ResponseEntity<List<Queue>>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("TryGetQueueToStudent/{idUser}")
    public ResponseEntity<List<Queue>> tryToGetQueueToStudent(@PathVariable("idUser") int idUser){
        List<Queue> queues = queueService.tryToGetQueue(idUser);
        if (queues != null){
            return new ResponseEntity<List<Queue>>(queues, HttpStatus.OK);
        } return new ResponseEntity<List<Queue>>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("Delete/Timetable/{timetableId}/Work/{idOfWork}/Student/{studentId}")
    public ResponseEntity deleteQueueByIdProfessorIdWorkIdStudent(@PathVariable("timetableId") int timetableId, @PathVariable("idOfWork") int idOfWork, @PathVariable("studentId") int studentId){
        queueService.deleteByIdTimetableIdWorkIdStudent(timetableId, idOfWork, studentId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("Student/{idUser}/Timetable/{idTimetable}")
    public ResponseEntity<List<Work>> getListQueueByTimetableAndStudentId(@PathVariable("idUser") int idUser, @PathVariable("idTimetable") int idTimetable){
        List<Queue> queues = queueService.getQueueToSubject(idTimetable, idUser);
        List<Work> works = new ArrayList<>();
        for (Queue queue :queues){
            works.add(queue.getWork());
        }
        if (queues != null) {
            return new ResponseEntity<List<Work>>(works, HttpStatus.OK);
        } return new ResponseEntity<List<Work>>(HttpStatus.NOT_FOUND);
    }
}
