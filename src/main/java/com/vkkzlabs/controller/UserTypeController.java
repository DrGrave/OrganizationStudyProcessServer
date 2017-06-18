package com.vkkzlabs.controller;

import com.vkkzlabs.entity.UserType;
import com.vkkzlabs.service.UserTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserTypeController{
    @Autowired
    UserTypeService userTypeService;

    @GetMapping("usertype/{id}")
    public ResponseEntity<UserType> getArticleById(@PathVariable("id") Integer id) {
        UserType article = userTypeService.getUserTypeByID(id);
        System.out.print(article);
        return new ResponseEntity<UserType>(article, HttpStatus.OK);
    }
}
