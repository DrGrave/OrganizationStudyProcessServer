package com.vkkzlabs.entity;

import javax.persistence.*;


@Entity
@Table(name = "myusercredentials")
public class UserCredentials {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="IdUserCredentials")
    private int userCredentialsID;

    @Column(name = "UserLogin")
    private String login;

    @Column(name = "UserPassword")
    private String password;

    @ManyToOne
        @JoinColumn(name = "IdUser")
        private User user;

    public int getUserCredentialsID() {
        return userCredentialsID;
    }

    public void setUserCredentialsID(int userCredentialsID) {
        this.userCredentialsID = userCredentialsID;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
