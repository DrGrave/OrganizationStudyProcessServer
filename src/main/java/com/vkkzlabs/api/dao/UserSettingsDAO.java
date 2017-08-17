package com.vkkzlabs.api.dao;

import com.vkkzlabs.api.entity.UserSettings;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Vadim on 14.07.2017.
 */
public interface UserSettingsDAO extends CrudRepository<UserSettings, Long>{
    UserSettings findByIdUserSettings(int idUserSettings);
}
