package com.vkkzlabs.entity;

import javax.persistence.*;

@Entity
@Table
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="IdUser")
    private int userID;

    @Column(name = "UserName")
    private String userName;

    @Column(name = "UserSurname")
    private String userSurname;

    @Column(name = "UserSeccondname")
    private String userSeccondname;

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSurname() {
        return userSurname;
    }

    public void setUserSurname(String userSurname) {
        this.userSurname = userSurname;
    }

    public String getUserSeccondname() {
        return userSeccondname;
    }

    public void setUserSeccondname(String userSeccondname) {
        this.userSeccondname = userSeccondname;
    }
}
