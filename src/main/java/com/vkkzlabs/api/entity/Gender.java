package com.vkkzlabs.api.entity;

import javax.persistence.*;

@Entity
@Table(name="Gender")
public class Gender {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idGender;

    @Column(name = "NameOdGender", nullable = false)
    private String nameOfGender;

    public int getIdGender() {
        return idGender;
    }

    public void setIdGender(int idGender) {
        this.idGender = idGender;
    }

    public String getNameOfGender() {
        return nameOfGender;
    }

    public void setNameOfGender(String nameOfGender) {
        this.nameOfGender = nameOfGender;
    }
}
