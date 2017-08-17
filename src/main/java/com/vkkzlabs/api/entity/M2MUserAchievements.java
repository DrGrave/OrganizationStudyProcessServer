package com.vkkzlabs.api.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "M2MUserAchievements")
public class M2MUserAchievements {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idM2MUserAchievement;

    @ManyToOne
    @JoinColumn(name = "idUser")
    private MyUser user;

    @ManyToOne
    @JoinColumn(name = "idAchievement")
    private Achievements achievement;

    @Column(name = "DateOfAchievement")
    private Date date;

    public int getIdM2MUserAchievement() {
        return idM2MUserAchievement;
    }

    public void setIdM2MUserAchievement(int idM2MUserAchievement) {
        this.idM2MUserAchievement = idM2MUserAchievement;
    }

    public MyUser getUser() {
        return user;
    }

    public void setUser(MyUser user) {
        this.user = user;
    }

    public Achievements getAchievement() {
        return achievement;
    }

    public void setAchievement(Achievements achievement) {
        this.achievement = achievement;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
