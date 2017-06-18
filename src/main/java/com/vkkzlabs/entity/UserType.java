package com.vkkzlabs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="UserType")
public class UserType {
    @Id
    @Column(name="IdUserType")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private
    int idUserType;

    @Column(name = "NameUserType")
    private
    String nameUserType;

    public int getIdUserType() {
        return idUserType;
    }

    public void setIdUserType(int idUserType) {
        this.idUserType = idUserType;
    }

    public String getNameUserType() {
        return nameUserType;
    }

    public void setNameUserType(String nameUserType) {
        this.nameUserType = nameUserType;
    }

    @Override
    public String toString() {
        return "UserType{" +
                "idUserType=" + idUserType +
                ", nameUserType='" + nameUserType + '\'' +
                '}';
    }
}