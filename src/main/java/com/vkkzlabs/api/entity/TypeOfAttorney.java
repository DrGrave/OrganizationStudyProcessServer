package com.vkkzlabs.api.entity;

import javax.persistence.*;


@Entity
@Table(name="TypeOfAttorney")
public class TypeOfAttorney {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private
    int idTypeOfAttorney;

    @Column(name = "NameOfTypeAttorney")
    private String nameOfTypeAttorney;

    public int getIdTypeOfAttorney() {
        return idTypeOfAttorney;
    }

    public void setIdTypeOfAttorney(int idTypeOfAttorney) {
        this.idTypeOfAttorney = idTypeOfAttorney;
    }

    public String getNameOfTypeAttorney() {
        return nameOfTypeAttorney;
    }

    public void setNameOfTypeAttorney(String nameOfTypeAttorney) {
        this.nameOfTypeAttorney = nameOfTypeAttorney;
    }

    @Override
    public String toString() {
        return "TypeOfAttorney{" +
                "idTypeOfAttorney=" + idTypeOfAttorney +
                ", nameOfTypeAttorney='" + nameOfTypeAttorney + '\'' +
                '}';
    }
}
