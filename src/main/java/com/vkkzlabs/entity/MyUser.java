package com.vkkzlabs.entity;

import javax.persistence.*;


@Entity
@Table(name="MyUser")
public class MyUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUser;


    @Column(name = "UserName", nullable = false)
    private String userName;

    @Column(name = "UserSurname", nullable = false)
    private String userSurname;

    @Column(name = "UserSecondname", nullable = false)
    private String userSecondname;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdGroup")
    private StudentGroup studentGroup;

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

    public String getUserSecondname() {
        return userSecondname;
    }

    public void setUserSecondname(String userSeccondname) {
        this.userSecondname = userSeccondname;
    }

    public StudentGroup getStudentGroup() {
        return studentGroup;
    }

    public void setStudentGroup(StudentGroup studentGroup) {
        this.studentGroup = studentGroup;
    }
}
