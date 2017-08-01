package com.vkkzlabs.service.Impl;

import com.vkkzlabs.dao.UserSettingsDAO;
import com.vkkzlabs.entity.UserSettings;
import com.vkkzlabs.service.UserSettingsService;
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
