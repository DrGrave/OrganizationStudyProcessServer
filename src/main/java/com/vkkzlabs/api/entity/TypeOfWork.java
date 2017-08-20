package com.vkkzlabs.api.entity;

import javax.persistence.*;

/**
 * Объект тип работы
 */

@Entity
@Table(name = "TypeOfWork")
public class TypeOfWork {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTypeOfWOrk;

    /**
     * название типа работы
     */

    @Column(name = "NameOfTypeWork")
    private String nameTypeOfWOrk;

    public int getIdTypeOfWOrk() {
        return idTypeOfWOrk;
    }

    public void setIdTypeOfWOrk(int idTypeOfWOrk) {
        this.idTypeOfWOrk = idTypeOfWOrk;
    }

    public String getNameTypeOfWOrk() {
        return nameTypeOfWOrk;
    }

    public void setNameTypeOfWOrk(String nameTypeOfWOrk) {
        this.nameTypeOfWOrk = nameTypeOfWOrk;
    }

    @Override
    public String toString() {
        return "TypeOfWork{" +
                "idTypeOfWOrk=" + idTypeOfWOrk +
                ", nameTypeOfWOrk='" + nameTypeOfWOrk + '\'' +
                '}';
    }
}
