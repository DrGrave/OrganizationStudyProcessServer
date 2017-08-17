package com.vkkzlabs.api.service;


import com.vkkzlabs.api.entity.UserSettings;

public interface UserSettingsService {
    void saveUserSettings(UserSettings userSettings);
    UserSettings getUserSettingsById(int userSettingsId);
}
