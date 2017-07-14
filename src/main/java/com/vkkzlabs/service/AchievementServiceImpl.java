package com.vkkzlabs.service;


import com.vkkzlabs.dao.AchievementsDAO;
import com.vkkzlabs.entity.Achievements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AchievementServiceImpl implements AchievementService{
    @Autowired
    AchievementsDAO achievementsDAO;

    @Override
    public void saveAchievement(Achievements achievements) {
        achievementsDAO.save(achievements);
    }

    @Override
    public Achievements getAchievementByIdAnswer(int achievementId) {
        return achievementsDAO.getByIdOfAchievement(achievementId);
    }
}
