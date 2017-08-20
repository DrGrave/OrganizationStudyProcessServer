package com.vkkzlabs.api.entity;

import javax.persistence.*;

/**
 * Объект предмет
 */

@Entity
@Table(name="Subject")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSubject;

    /**
     * Название предмета
     */

    @Column(name = "NameSubject")
    private String nameSubject;

    /**
     * Объект кафедра
     */

    @ManyToOne
    @JoinColumn(name = "IdChair")
    private Chair chair;

    public Chair getChair() {
        return chair;
    }

    public void setChair(Chair chair) {
        this.chair = chair;
    }

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
