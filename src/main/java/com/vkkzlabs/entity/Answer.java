package com.vkkzlabs.entity;

import javax.persistence.*;

/**
 * Created by Vadim on 08.07.2017.
 */
@Entity
@Table(name = "Answer")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private
    int idAnswer;

    @Column(name = "TextOfAnswer")
    private String textOfAnswer;

    @ManyToOne
    @JoinColumn(name = "idQuestion")
    private Question idQuestion;

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
