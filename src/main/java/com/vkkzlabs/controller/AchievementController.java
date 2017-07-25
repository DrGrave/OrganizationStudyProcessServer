package com.vkkzlabs.controller;

import com.vkkzlabs.entity.Achievements;
import com.vkkzlabs.entity.M2MUserAchievements;
import com.vkkzlabs.service.AchievementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("Achievement")
public class AchievementController {
    @Autowired
    private AchievementService achievementService;

    @GetMapping("{id}")
    public ResponseEntity<Achievements> getAchievementById(@PathVariable("id") int id) {
        Achievements achievements = achievementService.getAchievementByIdAnswer(id);
        if (achievements != null) {
            return new ResponseEntity<Achievements>(achievements, HttpStatus.OK);
        } return new ResponseEntity<Achievements>(HttpStatus.NOT_FOUND);
    }


}
