package com.vkkzlabs.api.entity;

import javax.persistence.*;

/**
 * Объект данные пользователя
 */

@Entity
@Table(name = "MyUserCredentials")
public class MyUserCredentials {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUserCredential;

    /**
     * Логин
     */

    @Column(name = "UserLogin")
    private String userLogin;

    /**
     * Пароль
     */

    @Column(name = "UserPassword")
    private String userPassword;

    /**
     * Объект пользователь
     */

    @OneToOne
    @JoinColumn(name = "IdUser")
    private MyUser MyUser;

    public MyUserCredentials(){}

    public MyUserCredentials(String userLogin, String userPassword) {
        this.userLogin = userLogin;
        this.userPassword = userPassword;
    }

    public int getIdUserCredential() {
        return idUserCredential;
    }

    public void setIdUserCredential(int idUserCredential) {
        this.idUserCredential = idUserCredential;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public MyUser getMyUser() {
        return MyUser;
    }

    public void setMyUser(MyUser MyUser) {
        this.MyUser = MyUser;
    }

    @Override
    public String toString() {
        return "MyUserCredentials{" +
                "idUserCredential=" + idUserCredential +
                ", userLogin='" + userLogin + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", MyUser=" + MyUser +
                '}';
    }
}
