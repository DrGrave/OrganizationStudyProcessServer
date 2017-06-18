package com.vkkzlabs.controller;

import com.vkkzlabs.entity.UserCredentials;
import com.vkkzlabs.service.UserCredentialsService;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

@Controller
@RequestMapping("user")
public class UserCredentialsController {
    @Autowired
    private
    UserCredentialsService userCredentialsService;

    @GetMapping("usercred/{id}")
    public ResponseEntity<UserCredentials> getArticleById(@PathVariable("id") Integer id) {
        UserCredentials article = userCredentialsService.getCtredById(id);
        return new ResponseEntity<UserCredentials>(article, HttpStatus.OK);
    }
}
