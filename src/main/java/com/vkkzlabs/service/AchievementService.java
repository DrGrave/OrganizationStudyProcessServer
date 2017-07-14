package com.vkkzlabs.service;


import com.vkkzlabs.entity.Achievements;

public interface AchievementService {
    void saveAchievement(Achievements achievements);
    Achievements getAchievementByIdAnswer(int achievementId);
}
