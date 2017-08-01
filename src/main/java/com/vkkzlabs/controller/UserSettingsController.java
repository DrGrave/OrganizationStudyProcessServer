package com.vkkzlabs.controller;

import com.vkkzlabs.entity.UserSettings;
import com.vkkzlabs.service.UserSettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("Settings")
public class UserSettingsController {
    @Autowired
    private UserSettingsService userSettingsService;


    @GetMapping("{id}")
    public ResponseEntity<UserSettings> getUserSettingsById(@PathVariable("id") Integer id) {
        UserSettings userSettings = userSettingsService.getUserSettingsById(id);
        if (userSettings != null) {
            return new ResponseEntity<UserSettings>(userSettings, HttpStatus.OK);
        } return new ResponseEntity<UserSettings>(HttpStatus.NOT_FOUND);
    }
}
