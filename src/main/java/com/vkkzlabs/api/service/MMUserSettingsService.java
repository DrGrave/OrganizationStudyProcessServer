package com.vkkzlabs.api.service;


import com.vkkzlabs.api.entity.M2MUserSettings;

public interface MMUserSettingsService {
    void saveUserSettings(M2MUserSettings m2MUserSettings);
    M2MUserSettings getUserSettingsById(int idUserSettings);

    M2MUserSettings getUserSettingByIdUserAndIdSetting(Integer idUser, Integer idSetting);

    void editUserSettings(M2MUserSettings userSettings);
}
