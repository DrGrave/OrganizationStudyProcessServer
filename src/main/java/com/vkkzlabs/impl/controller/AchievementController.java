package com.vkkzlabs.impl.controller;

import com.vkkzlabs.api.entity.Achievements;
import com.vkkzlabs.api.service.AchievementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Класс предназначен для мапинга запросов по ачивкам
 */

@Controller
@RequestMapping("Achievement")
public class AchievementController {
    @Autowired
    private AchievementService achievementService;


    /**
     * по запросу /Achievement/{id} возвращает объект Achievement
     */

    @GetMapping("{id}")
    public ResponseEntity<Achievements> getAchievementById(@PathVariable("id") int id) {
        Achievements achievements = achievementService.getAchievementByIdAnswer(id);
        if (achievements != null) {
            return new ResponseEntity<Achievements>(achievements, HttpStatus.OK);
        } return new ResponseEntity<Achievements>(HttpStatus.NOT_FOUND);
    }


}
