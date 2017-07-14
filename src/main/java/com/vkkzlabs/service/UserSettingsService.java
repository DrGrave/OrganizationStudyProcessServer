package com.vkkzlabs.service;


import com.vkkzlabs.entity.UserSettings;

public interface UserSettingsService {
    void saveUserSettings(UserSettings userSettings);
    UserSettings getUserSettingsById(int userSettingsId);
}
