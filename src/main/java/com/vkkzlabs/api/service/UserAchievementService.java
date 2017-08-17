package com.vkkzlabs.api.service;


import com.vkkzlabs.api.entity.M2MUserAchievements;

import java.util.List;

public interface UserAchievementService {
    void saveUserAchievement(M2MUserAchievements userAchievements);
    M2MUserAchievements getUserAchievementById(int idUserAchievement);

    List<M2MUserAchievements> getAchievementByUserId(int idUser);
}
