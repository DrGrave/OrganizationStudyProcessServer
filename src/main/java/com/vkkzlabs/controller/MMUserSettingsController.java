package com.vkkzlabs.controller;

import com.vkkzlabs.entity.M2MUserSettings;
import com.vkkzlabs.service.MMUserSettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@Controller
@RequestMapping("UserSettings")
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

    @GetMapping("User/{idUser}/Setting/{idSetting}")
    public ResponseEntity<M2MUserSettings> getUserSettingsByIdUserAndIdSetting(@PathVariable("idUser") Integer idUser, @PathVariable("idSetting") Integer idSetting) {
        M2MUserSettings userSettings = mmUserSettingsService.getUserSettingByIdUserAndIdSetting(idUser, idSetting);
        if (userSettings != null) {
            return new ResponseEntity<M2MUserSettings>(userSettings, HttpStatus.OK);
        } return new ResponseEntity<M2MUserSettings>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "Save", method = RequestMethod.POST)
    public ResponseEntity saveSetting(@RequestBody M2MUserSettings userSettings, UriComponentsBuilder ucBuilder) {
        mmUserSettingsService.saveUserSettings(userSettings);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "Edit", method = RequestMethod.POST)
    public ResponseEntity editSetting(@RequestBody M2MUserSettings userSettings, UriComponentsBuilder ucBuilder) {
        mmUserSettingsService.editUserSettings(userSettings);
        return new ResponseEntity(HttpStatus.OK);
    }
}
