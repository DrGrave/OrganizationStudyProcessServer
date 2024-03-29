package com.vkkzlabs.api.dao;


import com.vkkzlabs.api.entity.M2MUserSettings;
import org.springframework.data.repository.CrudRepository;

public interface MMUserSettingsDAO extends CrudRepository<M2MUserSettings, Long>{
    M2MUserSettings getByIdM2MUserSettings(int idMMUserSettings);

    M2MUserSettings findByMyUser_IdUserAndSetting_IdUserSettings(Integer idUser, Integer idSetting);

}
