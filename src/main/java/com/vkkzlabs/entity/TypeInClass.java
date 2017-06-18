package com.vkkzlabs.entity;

import javax.persistence.*;

/**
 * Created by vadim on 03.04.17.
 */
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
