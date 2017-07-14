package com.vkkzlabs.dao;

import com.vkkzlabs.entity.UserSettings;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Vadim on 14.07.2017.
 */
public interface UserSettingsDAO extends CrudRepository<UserSettings, Long>{
    UserSettings getByIdUserSettings(int idUserSettings);
}
