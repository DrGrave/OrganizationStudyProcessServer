package com.vkkzlabs.api.entity;

import javax.persistence.*;

/**
 * Настройки пользователя
 */

@Entity
@Table(name = "UserSettings")
public class UserSettings {
    @Id
    @Column(name="IdUserSettings")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int idUserSettings;

    /**
     * Название настройки
     */

    @Column(name = "SittingInfo")
    private String sittingInfo;

    public int getIdUserSettings() {
        return idUserSettings;
    }

    public void setIdUserSettings(int idUserSettings) {
        this.idUserSettings = idUserSettings;
    }

    public String getSittingInfo() {
        return sittingInfo;
    }

    public void setSittingInfo(String sittingInfo) {
        this.sittingInfo = sittingInfo;
    }
}
