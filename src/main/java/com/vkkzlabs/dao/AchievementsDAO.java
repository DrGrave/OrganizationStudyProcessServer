package com.vkkzlabs.dao;


import com.vkkzlabs.entity.Achievements;
import org.springframework.data.repository.CrudRepository;

public interface AchievementsDAO extends CrudRepository<Achievements, Long> {
    Achievements getByIdOfAchievement(int idAchievement);
}
