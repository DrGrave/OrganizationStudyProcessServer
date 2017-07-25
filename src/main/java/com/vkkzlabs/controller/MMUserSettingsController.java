package com.vkkzlabs.controller;

import com.vkkzlabs.entity.M2MUserSettings;
import com.vkkzlabs.service.MMUserSettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("MMUserSettings")
public class MMUserSettingsController {
    @Autowired
    private MMUserSettingsService mmUserSettingsService;

    @GetMapping("{id}")
    public ResponseEntity<M2MUserSettings> getUserSettingsById(@PathVariable("id") Integer id) {
        M2MUserSettings userSettings = mmUserSettingsService.getUserSettingsById(id);
        if (userSettings != null) {
            return new ResponseEntity<M2MUserSettings>(userSettings, HttpStatus.OK);
        } return new ResponseEntity<M2MUserSettings>(HttpStatus.NOT_FOUND);
    }
}
