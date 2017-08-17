package com.vkkzlabs.impl.controller;

import com.vkkzlabs.api.entity.M2MUserAchievements;
import com.vkkzlabs.api.service.UserAchievementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

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

    @GetMapping("IdUser/{id}")
    public ResponseEntity<List<M2MUserAchievements>> getAchievementByUserId(@PathVariable("id") int idUser){
        List<M2MUserAchievements> achievements = userAchievementService.getAchievementByUserId(idUser);
        if (achievements != null){
            return new ResponseEntity<List<M2MUserAchievements>>(achievements, HttpStatus.OK);
        } return new ResponseEntity<List<M2MUserAchievements>>(HttpStatus.NOT_FOUND);
    }
}
