package com.vkkzlabs.impl.controller;

import com.vkkzlabs.api.entity.MyUserCredentials;
import com.vkkzlabs.api.service.UserCredentialsService;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *  Ненужный класс
 */

@Controller
@RequestMapping("UserCredentials")
public class UserCredentialsController {
    @Autowired
    private UserCredentialsService userCredentialsService;

    @GetMapping("{id}")
    public ResponseEntity<MyUserCredentials> getUserCredentialsById(@PathVariable("id") Integer id) {
        MyUserCredentials userCredentials = userCredentialsService.getCtredById(id);
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Access-Control-Allow-Origin", "*");
        responseHeaders.set("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
        if (userCredentials != null) {
            return new ResponseEntity<MyUserCredentials>(userCredentials,responseHeaders ,HttpStatus.OK);
        }return new ResponseEntity<MyUserCredentials>(responseHeaders, HttpStatus.NOT_FOUND);
    }
}
