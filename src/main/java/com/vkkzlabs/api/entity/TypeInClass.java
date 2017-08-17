package com.vkkzlabs.api.entity;

import javax.persistence.*;


@Entity
@Table(name="TypeInClass")
public class TypeInClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private
    int idTypeInClass;

    @Column(name = "NameTypeInClass")
    private
    String nameTypeInClass;

    public int getIdTypeInClass() {
        return idTypeInClass;
    }

    public void setIdTypeInClass(int idTypeInClass) {
        this.idTypeInClass = idTypeInClass;
    }

    public String getNameTypeInClass() {
        return nameTypeInClass;
    }

    public void setNameTypeInClass(String nameTypeInClass) {
        this.nameTypeInClass = nameTypeInClass;
    }

    @Override
    public String toString() {
        return "TypeInClass{" +
                "idTypeInClass=" + idTypeInClass +
                ", nameTypeInClass='" + nameTypeInClass + '\'' +
                '}';
    }
}
