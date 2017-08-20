package com.vkkzlabs.api.entity;

import javax.persistence.*;

/**
 * Тип ответа на вопрос
 */

@Entity
@Table(name = "TypeOfAnswer")
public class TypeOfAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private
    int idTypeOfAnswer;

    /**
     * Название типа ответа
     */

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
