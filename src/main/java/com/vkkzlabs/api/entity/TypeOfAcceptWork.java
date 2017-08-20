package com.vkkzlabs.api.entity;

import javax.persistence.*;

/**
 * Тип приннятия работы
 */

@Entity
@Table(name="TypeOfAcceptWork")
public class TypeOfAcceptWork {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idOfAccaptWork;

    /**
     * Название типа принятия работы
     */

    @Column(name = "NameOfAccaptWork")
    private String nameOfAccaptWork;

    public int getIdOfAccaptWork() {
        return idOfAccaptWork;
    }

    public void setIdOfAccaptWork(int idOfAccaptWork) {
        this.idOfAccaptWork = idOfAccaptWork;
    }

    public String getNameOfAccaptWork() {
        return nameOfAccaptWork;
    }

    public void setNameOfAccaptWork(String nameOfAccaptWork) {
        this.nameOfAccaptWork = nameOfAccaptWork;
    }
}
