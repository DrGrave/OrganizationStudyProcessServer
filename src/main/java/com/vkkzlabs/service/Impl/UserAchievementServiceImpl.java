package com.vkkzlabs.service.Impl;

import com.vkkzlabs.dao.UserAchievementDAO;
import com.vkkzlabs.entity.M2MUserAchievements;
import com.vkkzlabs.service.UserAchievementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAchievementServiceImpl implements UserAchievementService {
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

    @Override
    public List<M2MUserAchievements> getAchievementByUserId(int idUser) {
        return userAchievementDAO.findAllByUser_IdUser(idUser);
    }
}
