package com.vkkzlabs.service;


import com.vkkzlabs.entity.M2MUserAchievements;

import java.util.List;

public interface UserAchievementService {
    void saveUserAchievement(M2MUserAchievements userAchievements);
    M2MUserAchievements getUserAchievementById(int idUserAchievement);

    List<M2MUserAchievements> getAchievementByUserId(int idUser);
}
