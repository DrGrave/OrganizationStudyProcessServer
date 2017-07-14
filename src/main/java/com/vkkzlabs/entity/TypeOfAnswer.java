package com.vkkzlabs.entity;

import javax.persistence.*;


@Entity
@Table(name = "TypeOfAnswer")
public class TypeOfAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private
    int idTypeOfAnswer;

    @Column(name = "NameTypeOfAnswer")
    private String nameTypeOfAnswer;

    public int getIdTypeOfAnswer() {
        return idTypeOfAnswer;
    }

    public void setIdTypeOfAnswer(int idTypeOfAnswer) {
        this.idTypeOfAnswer = idTypeOfAnswer;
    }

    public String getNameTypeOfAnswer() {
        return nameTypeOfAnswer;
    }

    public void setNameTypeOfAnswer(String nameTypeOfAnswer) {
        this.nameTypeOfAnswer = nameTypeOfAnswer;
    }
}
