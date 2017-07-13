package com.vkkzlabs.controller;


import com.vkkzlabs.entity.MyUser;
import com.vkkzlabs.service.InClassService;
import com.vkkzlabs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("User")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("{id}")
    public ResponseEntity<MyUser> getUserById(@PathVariable("id") Integer id) {
        MyUser article = userService.getUserById(id);
        return new ResponseEntity<MyUser>(article, HttpStatus.OK);
    }
}
