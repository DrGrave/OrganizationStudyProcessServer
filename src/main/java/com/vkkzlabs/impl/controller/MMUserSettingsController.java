package com.vkkzlabs.impl.controller;

import com.vkkzlabs.api.entity.M2MUserSettings;
import com.vkkzlabs.api.service.MMUserSettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

/**
 *  Данный класс предназначен для мапинга запросов связанных с персоональными настройками юзверя
 */

@Controller
@RequestMapping("UserSettings")
public class MMUserSettingsController {
    @Autowired
    private MMUserSettingsService mmUserSettingsService;

    /**
     * по запросу /UserSettings/{id} возвращает объект по его Id
     */

    @GetMapping("{id}")
    public ResponseEntity<M2MUserSettings> getUserSettingsById(@PathVariable("id") Integer id) {
        M2MUserSettings userSettings = mmUserSettingsService.getUserSettingsById(id);
        if (userSettings != null) {
            return new ResponseEntity<M2MUserSettings>(userSettings, HttpStatus.OK);
        } return new ResponseEntity<M2MUserSettings>(HttpStatus.NOT_FOUND);
    }

    /**
     * по запросу /User/{idUser}/Setting/{idSetting} возвращает объект по id юзера и id предмета
     */

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
