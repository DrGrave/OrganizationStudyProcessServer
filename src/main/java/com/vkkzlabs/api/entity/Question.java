package com.vkkzlabs.api.entity;

import javax.persistence.*;

/**
 * Объект вопрос
 */

@Entity
@Table(name="Question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private
    int idQuestion;

    /**
     * Текст вопроса
     */

    @Column(name = "TextOfQuestion")
    private String textOfQuestion;

    /**
     * Объект тема
     */

    @ManyToOne
    @JoinColumn(name = "IdTopic")
    private Topics topics;

    /**
     * Объект тип вопроса
     */

    @ManyToOne
    @JoinColumn(name = "IdTypeQuestion")
    private TypeOfQuestion typeOfQuestion;


    public int getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(int idQuestion) {
        this.idQuestion = idQuestion;
    }

    public String getTextOfQuestion() {
        return textOfQuestion;
    }

    public void setTextOfQuestion(String textOfQuestion) {
        this.textOfQuestion = textOfQuestion;
    }

    public Topics getTopics() {
        return topics;
    }

    public void setTopics(Topics topics) {
        this.topics = topics;
    }

    public TypeOfQuestion getTypeOfQuestion() {
        return typeOfQuestion;
    }

    public void setTypeOfQuestion(TypeOfQuestion typeOfQuestion) {
        this.typeOfQuestion = typeOfQuestion;
    }
}
