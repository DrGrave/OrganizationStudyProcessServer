package com.vkkzlabs.impl.service;

import com.vkkzlabs.api.dao.MMUserSettingsDAO;
import com.vkkzlabs.api.entity.M2MUserSettings;
import com.vkkzlabs.api.service.MMUserSettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *  Сервис для работы с связью юзверя и его настроек
 */

@Service
public class MMUserSettingsServiceImpl implements MMUserSettingsService {
    @Autowired
    private MMUserSettingsDAO mmUserSettingsDAO;

    @Override
    public void saveUserSettings(M2MUserSettings m2MUserSettings) {
        mmUserSettingsDAO.save(m2MUserSettings);
    }

    @Override
    public M2MUserSettings getUserSettingsById(int idUserSettings) {
        return mmUserSettingsDAO.getByIdM2MUserSettings(idUserSettings);
    }

    @Override
    public M2MUserSettings getUserSettingByIdUserAndIdSetting(Integer idUser, Integer idSetting) {
        return mmUserSettingsDAO.findByMyUser_IdUserAndSetting_IdUserSettings(idUser, idSetting);
    }

    @Override
    public void editUserSettings(M2MUserSettings userSettings) {
        mmUserSettingsDAO.save(userSettings);
    }
}
