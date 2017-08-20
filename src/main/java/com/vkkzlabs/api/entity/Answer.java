package com.vkkzlabs.api.entity;

import javax.persistence.*;

/**
 * Обьект ответ на вопрос
 */

@Entity
@Table(name = "Answer")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAnswer;

    /**
     * текст ответа
     */
    @Column(name = "TextOfAnswer")
    private String textOfAnswer;

    /**
     * объект вопрос
     */
    @ManyToOne
    @JoinColumn(name = "idQuestion")
    private Question idQuestion;

    /**
     * объект тип ответа
     */
    @ManyToOne
    @JoinColumn(name = "idTypeOfAnswer")
    private TypeOfAnswer typeOfAnswer;

    public int getIdAnswer() {
        return idAnswer;
    }

    public void setIdAnswer(int idAnswer) {
        this.idAnswer = idAnswer;
    }

    public String getTextOfAnswer() {
        return textOfAnswer;
    }

    public void setTextOfAnswer(String textOfAnswer) {
        this.textOfAnswer = textOfAnswer;
    }

    public Question getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(Question idQuestion) {
        this.idQuestion = idQuestion;
    }

    public TypeOfAnswer getTypeOfAnswer() {
        return typeOfAnswer;
    }

    public void setTypeOfAnswer(TypeOfAnswer typeOfAnswer) {
        this.typeOfAnswer = typeOfAnswer;
    }
}
