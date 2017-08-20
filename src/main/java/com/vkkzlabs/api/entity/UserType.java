package com.vkkzlabs.api.entity;

import javax.persistence.*;

/**
 * Объект тип пользователя
 */

@Entity
@Table(name="UserType")
public class UserType {
    @Id
    @Column(name="IdUserType")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int idUserType;

    @Column(name = "NameUserType")
    private String nameUserType;

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
