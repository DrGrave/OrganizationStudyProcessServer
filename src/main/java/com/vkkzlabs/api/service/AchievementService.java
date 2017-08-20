package com.vkkzlabs.api.service;


import com.vkkzlabs.api.entity.Achievements;

public interface AchievementService {
    void saveAchievement(Achievements achievements);
    Achievements getAchievementByIdAnswer(int achievementId);
}
