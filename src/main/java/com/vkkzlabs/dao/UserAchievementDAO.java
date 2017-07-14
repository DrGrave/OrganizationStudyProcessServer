package com.vkkzlabs.dao;


import com.vkkzlabs.entity.M2MUserAchievements;
import org.springframework.data.repository.CrudRepository;

public interface UserAchievementDAO extends CrudRepository<M2MUserAchievements, Long> {
    M2MUserAchievements getByIdM2MUserAchievement(int idUserAchievement);
}
