package com.vkkzlabs.entity;

import javax.persistence.*;


@Entity
@Table(name="TypeOfAcceptWork")
public class TypeOfAcceptWork {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idOfAccaptWork;

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
