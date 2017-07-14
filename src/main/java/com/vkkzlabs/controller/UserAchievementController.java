package com.vkkzlabs.controller;

import com.vkkzlabs.entity.M2MUserAchievements;
import com.vkkzlabs.service.UserAchievementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("UserAchievement")
public class UserAchievementController {
    @Autowired
    private UserAchievementService userAchievementService;

    @GetMapping("{id}")
    public ResponseEntity<M2MUserAchievements> getUserAchievementById(@PathVariable("id") Integer id) {
        M2MUserAchievements userAchievements = userAchievementService.getUserAchievementById(id);
        if (userAchievements != null) {
            return new ResponseEntity<M2MUserAchievements>(userAchievements, HttpStatus.OK);
        } return new ResponseEntity<M2MUserAchievements>(HttpStatus.NOT_FOUND);
    }
}
