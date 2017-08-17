package com.vkkzlabs.impl.service;

import com.vkkzlabs.api.dao.UserSettingsDAO;
import com.vkkzlabs.api.entity.UserSettings;
import com.vkkzlabs.api.service.UserSettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserSettingsServiceImpl implements UserSettingsService {
    @Autowired
    private UserSettingsDAO userSettingsDAO;

    @Override
    public void saveUserSettings(UserSettings userSettings) {
        userSettingsDAO.save(userSettings);
    }

    @Override
    public UserSettings getUserSettingsById(int userSettingsId) {
        return userSettingsDAO.findByIdUserSettings(userSettingsId);
    }
}
