package com.vkkzlabs.api.entity;

import javax.persistence.*;

/**
 * Объект тип вопроса
 */

@Entity
@Table(name="TypeOfQuestion")
public class TypeOfQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private
    int idTypeOfQuestion;

    /**
     * Название типа вопроса
     */

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
