package com.vkkzlabs.dao;


import com.vkkzlabs.entity.M2MUserSettings;
import org.springframework.data.repository.CrudRepository;

public interface MMUserSettingsDAO extends CrudRepository<M2MUserSettings, Long>{
    M2MUserSettings getByIdM2MUserSettings(int idMMUserSettings);
}
