package com.vkkzlabs.api.entity;

import javax.persistence.*;
import java.sql.Date;

/**
 * Объект пользователь
 */

@Entity
@Table(name="MyUser")
public class MyUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUser;

    /**
     * Дата зачисления
     */

    @Column(name = "DateOfEnrollment")
    private Date dateOfEnrollment;

    /**
     * Имя пользователя
     */

    @Column(name = "UserName", nullable = false)
    private String userName;

    /**
     * Фамилия пользователя
     */

    @Column(name = "UserSurname", nullable = false)
    private String userSurname;

    /**
     * Отчество пользователя
     */

    @Column(name = "UserPatronymic", nullable = false)
    private String userPatronymic;

    /**
     * Мыло юзверя
     */

    @Column(name = "Email", nullable = false)
    private String email;

    /**
     * Объект пола пользователя
     */

    @ManyToOne
    @JoinColumn(name = "Gender")
    private Gender gender;

    /**
     * Объект группа студента
     */

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdGroup")
    private StudentGroup studentGroup;

    /**
     * Объект тип юзверя
     */

    @ManyToOne
    @JoinColumn(name = "IdUserType")
    private UserType userType;

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public MyUser() {
    }


    public Date getDateOfEnrollment() {
        return dateOfEnrollment;
    }

    public void setDateOfEnrollment(Date dateOfEnrollment) {
        this.dateOfEnrollment = dateOfEnrollment;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
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

    public String getUserPatronymic() {
        return userPatronymic;
    }

    public void setUserPatronymic(String userPatronymic) {
        this.userPatronymic = userPatronymic;
    }

    public StudentGroup getStudentGroup() {
        return studentGroup;
    }

    public void setStudentGroup(StudentGroup studentGroup) {
        this.studentGroup = studentGroup;
    }
}
