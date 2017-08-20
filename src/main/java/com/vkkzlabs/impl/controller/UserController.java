package com.vkkzlabs.impl.controller;


import com.vkkzlabs.api.entity.MyUser;
import com.vkkzlabs.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *  Для работы с пользователем
 */

@Controller
@RequestMapping("User")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("{id}")
    public ResponseEntity<MyUser> getUserById(@PathVariable("id") Integer id) {
        MyUser user = userService.getUserById(id);
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Access-Control-Allow-Origin", "*");
        responseHeaders.set("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
        if (user != null) {
            return new ResponseEntity<MyUser>(user,responseHeaders , HttpStatus.OK);
        }return new ResponseEntity<MyUser>(responseHeaders, HttpStatus.NOT_FOUND);
    }
}
