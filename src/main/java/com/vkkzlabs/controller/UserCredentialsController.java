package com.vkkzlabs.controller;

import com.vkkzlabs.entity.MyUserCredentials;
import com.vkkzlabs.service.UserCredentialsService;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("UserCredentials")
public class UserCredentialsController {
    @Autowired
    private UserCredentialsService userCredentialsService;

    @GetMapping("{id}")
    public ResponseEntity<MyUserCredentials> getUserCredentialsById(@PathVariable("id") Integer id) {
        MyUserCredentials userCredentials = userCredentialsService.getCtredById(id);
        if (userCredentials != null) {
            return new ResponseEntity<MyUserCredentials>(userCredentials, HttpStatus.OK);
        }return new ResponseEntity<MyUserCredentials>(HttpStatus.NOT_FOUND);
    }
}
