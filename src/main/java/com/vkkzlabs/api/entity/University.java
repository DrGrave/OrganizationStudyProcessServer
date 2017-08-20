package com.vkkzlabs.api.entity;

import javax.persistence.*;

/**
 * Объект университет
 */

@Entity
@Table(name = "University")
public class University {
    @Id
    @Column(name="IdUniversity")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int idUniversity;
    /**
     * Название университета
     */

    @Column(name = "NameUniversity")
    private String nameUniversity;

    public int getIdUniversity() {
        return idUniversity;
    }

    public void setIdUniversity(int idUniversity) {
        this.idUniversity = idUniversity;
    }

    public String getNameUniversity() {
        return nameUniversity;
    }

    public void setNameUniversity(String nameUniversity) {
        this.nameUniversity = nameUniversity;
    }
}
