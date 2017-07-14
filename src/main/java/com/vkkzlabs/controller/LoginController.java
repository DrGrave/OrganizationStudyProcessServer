package com.vkkzlabs.controller;

import com.vkkzlabs.entity.MyUser;
import com.vkkzlabs.entity.MyUserCredentials;
import com.vkkzlabs.service.UserCredentialsService;
import com.vkkzlabs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.authentication.UserCredentials;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@Controller

public class LoginController {
    @Autowired
    private UserCredentialsService userCredentialsService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public ResponseEntity<MyUser> getTypeOfAnswerById(@RequestBody MyUserCredentials userCredentials, UriComponentsBuilder ucBuilder) {
        userCredentialsService.getUserByLogin(userCredentials.getUserLogin());
        MyUser myUser = userService.getUserById(userCredentials.getMyUser().getIdUser());
        if (myUser != null) {
            return new ResponseEntity<MyUser>(myUser, HttpStatus.OK);
        } return new ResponseEntity<MyUser>(HttpStatus.NOT_FOUND);
    }
}
