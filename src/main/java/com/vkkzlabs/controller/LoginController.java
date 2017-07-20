package com.vkkzlabs.controller;

import com.vkkzlabs.entity.MyUser;
import com.vkkzlabs.entity.MyUserCredentials;
import com.vkkzlabs.service.UserCredentialsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@Controller
public class LoginController {
    @Autowired
    private UserCredentialsService userCredentialsService;

    @RequestMapping(value = "GetUser", method = RequestMethod.POST)
    public ResponseEntity<MyUser> getUserByLogin(@RequestBody MyUserCredentials userCredentials, UriComponentsBuilder ucBuilder) {

        MyUser myUser = userCredentialsService.getUserByLogin(userCredentials.getUserLogin()).getMyUser();
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Access-Control-Allow-Origin", "*");
        responseHeaders.set("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
        if (myUser != null) {
            return new ResponseEntity<MyUser>(myUser,responseHeaders , HttpStatus.OK);
        } return new ResponseEntity<MyUser>(responseHeaders, HttpStatus.NOT_FOUND);
    }
}
