package com.vkkzlabs.entity;

import javax.persistence.*;


@Entity
@Table(name="TypeOfQuestion")
public class TypeOfQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private
    int idTypeOfQuestion;

    @Column(name = "NameQuestionType")
    private String nameQuestionType;

    public int getIdTypeOfQuestion() {
        return idTypeOfQuestion;
    }

    public void setIdTypeOfQuestion(int idTypeOfQuestion) {
        this.idTypeOfQuestion = idTypeOfQuestion;
    }

    public String getNameQuestionType() {
        return nameQuestionType;
    }

    public void setNameQuestionType(String nameQuestionType) {
        this.nameQuestionType = nameQuestionType;
    }


}
