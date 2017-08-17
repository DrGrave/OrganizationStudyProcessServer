package com.vkkzlabs.impl.service;


import com.vkkzlabs.api.dao.AchievementsDAO;
import com.vkkzlabs.api.entity.Achievements;
import com.vkkzlabs.api.service.AchievementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AchievementServiceImpl implements AchievementService {
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
