package com.vkkzlabs.service;


import com.vkkzlabs.entity.M2MUserAchievements;

public interface UserAchievementService {
    void saveUserAchievement(M2MUserAchievements userAchievements);
    M2MUserAchievements getUserAchievementById(int idUserAchievement);
}
