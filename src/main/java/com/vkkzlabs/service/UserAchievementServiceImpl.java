package com.vkkzlabs.service;

import com.vkkzlabs.dao.UserAchievementDAO;
import com.vkkzlabs.entity.M2MUserAchievements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAchievementServiceImpl implements UserAchievementService{
    @Autowired
    private UserAchievementDAO userAchievementDAO;

    @Override
    public void saveUserAchievement(M2MUserAchievements userAchievements) {
        userAchievementDAO.save(userAchievements);
    }

    @Override
    public M2MUserAchievements getUserAchievementById(int idUserAchievement) {
        return userAchievementDAO.getByIdM2MUserAchievement(idUserAchievement);
    }
}
