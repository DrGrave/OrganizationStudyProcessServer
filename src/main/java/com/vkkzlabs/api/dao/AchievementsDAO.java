package com.vkkzlabs.api.dao;


import com.vkkzlabs.api.entity.Achievements;
import org.springframework.data.repository.CrudRepository;

public interface AchievementsDAO extends CrudRepository<Achievements, Long> {
    Achievements getByIdOfAchievement(int idAchievement);
}
