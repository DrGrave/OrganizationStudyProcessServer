package com.vkkzlabs.impl.controller;

import com.vkkzlabs.api.entity.Work;
import com.vkkzlabs.api.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

/**
 *  Для работы с работами для студентов
 */

@Controller
@RequestMapping("Work")
public class WorkController {
    @Autowired
    private WorkService workService;

    @GetMapping("{id}")
    public ResponseEntity<Work> getWorkById(@PathVariable("id") Integer id) {
        Work work = workService.getWorkByIdWork(id);
        if (work != null) {
            return new ResponseEntity<Work>(work, HttpStatus.OK);
        } return new ResponseEntity<Work>(HttpStatus.NOT_FOUND);
    }
    @GetMapping("ListToProfessor/{idProfessor}/Subject/{idSubject}")
    public ResponseEntity<List<Work>> getWorksBySubject(@PathVariable("idProfessor") int idProfessor, @PathVariable("idSubject") int idSubject){
        List<Work> works = workService.getWorksByIdUserAndIdSubject(idProfessor, idSubject);
        if (works != null) {
            return new ResponseEntity<List<Work>>(works, HttpStatus.OK);
        } return new ResponseEntity<List<Work>>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("Save")
    public  ResponseEntity saveWork(@RequestBody Work work, UriComponentsBuilder uriComponentsBuilder){

            workService.saveWork(work);
            if (work != null) {
                return new ResponseEntity<>(HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("Delete")
    public  ResponseEntity deleteWork(@RequestBody Work work, UriComponentsBuilder uriComponentsBuilder){

        workService.deleteWork(work);
        if (work != null) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("Change")
    public  ResponseEntity changeWork(@RequestBody Work work, UriComponentsBuilder uriComponentsBuilder){

        workService.changeWork(work);
        if (work != null) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
