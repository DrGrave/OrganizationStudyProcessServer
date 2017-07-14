package com.vkkzlabs.entity;

import javax.persistence.*;


@Entity
@Table(name="Subject")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private
    int idSubject;

    @Column(name = "NameSubject")
    private
    String nameSubject;

    public int getIdSubject() {
        return idSubject;
    }

    public void setIdSubject(int idSubject) {
        this.idSubject = idSubject;
    }

    public String getNameSubject() {
        return nameSubject;
    }

    public void setNameSubject(String nameSubject) {
        this.nameSubject = nameSubject;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "idSubject=" + idSubject +
                ", nameSubject='" + nameSubject + '\'' +
                '}';
    }
}
