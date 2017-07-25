package com.vkkzlabs.dao;


import com.vkkzlabs.entity.M2MUserAchievements;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserAchievementDAO extends CrudRepository<M2MUserAchievements, Long> {
    M2MUserAchievements getByIdM2MUserAchievement(int idUserAchievement);

    List<M2MUserAchievements> findAllByUser_IdUser(int idUser);
}
