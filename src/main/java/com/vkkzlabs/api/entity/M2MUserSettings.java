package com.vkkzlabs.api.entity;

import javax.persistence.*;

/**
 * Объект для связи пользователя и его наастроек
 */

@Entity
@Table(name = "M2MUserSettings")
public class M2MUserSettings {
    @Id
    @Column(name = "idM2MUserSettings")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idM2MUserSettings;

    /**
     * Путь к файлу
     */

    @Column(name = "PathToDirectory")
    private String pathToDirectoty;

    /**
     * Объект пользователя
     */

    @ManyToOne
        @JoinColumn(name = "idUser")
    private MyUser myUser;

    /**
     * Объект настройки
     */

    @ManyToOne
        @JoinColumn(name = "idSetting")
    private UserSettings setting;

    /**
     * Включена ли настройка
     */

    @Column(name = "isSettingOn")
    private boolean isSettingOn;

    public int getIdM2MUserSettings() {
        return idM2MUserSettings;
    }

    public void setIdM2MUserSettings(int idM2MUserSettings) {
        this.idM2MUserSettings = idM2MUserSettings;
    }

    public MyUser getMyUser() {
        return myUser;
    }

    public void setMyUser(MyUser myUser) {
        this.myUser = myUser;
    }

    public UserSettings getSetting() {
        return setting;
    }

    public void setSetting(UserSettings setting) {
        this.setting = setting;
    }

    public String getPathToDirectoty() {
        return pathToDirectoty;
    }

    public void setPathToDirectoty(String pathToDirectoty) {
        this.pathToDirectoty = pathToDirectoty;
    }

    public boolean isSettingOn() {
        return isSettingOn;
    }

    public void setSettingOn(boolean settingOn) {
        isSettingOn = settingOn;
    }
}
