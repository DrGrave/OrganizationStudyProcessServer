package com.vkkzlabs.entity;

import javax.persistence.*;

@Entity
@Table(name = "M2MUserSettings")
public class M2MUserSettings {
    @Id
    @Column(name = "idM2MUserSettings")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idM2MUserSettings;

    @ManyToOne
        @JoinColumn(name = "idUser")
    private MyUser myUser;

    @ManyToOne
        @JoinColumn(name = "idSetting")
    private UserSettings setting;

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
}
