package com.vkkzlabs.impl.controller;

import com.vkkzlabs.api.entity.UserType;
import com.vkkzlabs.api.service.UserTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *  Для работы с типами юзверей
 */

@Controller
@RequestMapping("UserType")
public class UserTypeController{
    @Autowired
    private UserTypeService userTypeService;

    @GetMapping("{id}")
    public ResponseEntity<UserType> getUserTypeById(@PathVariable("id") Integer id) {
        UserType userType = userTypeService.getUserTypeByID(id);
        if (userType != null) {
            return new ResponseEntity<UserType>(userType, HttpStatus.OK);
        }return new ResponseEntity<UserType>(HttpStatus.NOT_FOUND);
    }
}
