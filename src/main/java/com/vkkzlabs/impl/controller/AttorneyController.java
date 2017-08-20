package com.vkkzlabs.impl.controller;

import com.vkkzlabs.api.entity.Attorney;
import com.vkkzlabs.api.service.AttorneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Класс предназначен для мапинга доверенностей на студентов
 */

@Controller
@RequestMapping("Attorney")
public class AttorneyController {
    @Autowired
    private AttorneyService attorneyService;

    /**
     * по запросу /Attorney/{id} возвращает объект Attorney
     */

    @GetMapping("{id}")
    public ResponseEntity<Attorney> getAttorneyById(@PathVariable("id") Integer id) {
        Attorney attorney = attorneyService.getAttorneyByIdAttorney(id);
        if (attorney != null) {
            return new ResponseEntity<Attorney>(attorney, HttpStatus.OK);
        }return new ResponseEntity<Attorney>(HttpStatus.NOT_FOUND);
    }

}
