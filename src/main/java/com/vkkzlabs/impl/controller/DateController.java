package com.vkkzlabs.impl.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Date;
/**
 * Данный класс возвращает актуальную дату сервера
 */

@Controller
@RequestMapping("GetServerDate")
public class DateController {

    /**
     * по запросу /GetServerDate/Date возвращает серверное время
     */
    @GetMapping("Get")
    public ResponseEntity<Date> getDateOfServer() {
        Date date = new Date(System.currentTimeMillis());
        if (date != null) {
            return new ResponseEntity<Date>(date, HttpStatus.OK);
        } return new ResponseEntity<Date>(HttpStatus.NOT_FOUND);
    }
}
