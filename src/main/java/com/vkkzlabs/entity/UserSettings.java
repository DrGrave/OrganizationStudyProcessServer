package com.vkkzlabs.entity;

import javax.persistence.*;

@Entity
@Table(name = "UserSettings")
public class UserSettings {
    @Id
    @Column(name="IdUserSettings")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int idUserSettings;

    @Column(name = "SunSetting")
    private boolean setting;
}
