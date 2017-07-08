package com.vkkzlabs.entity;

import javax.persistence.*;

/**
 * Created by Vadim on 08.07.2017.
 */
@Entity
@Table(name="Question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private
    int idQuestion;

    @Column(name = "TextOfQuestion")
    private String textOfQuestion;

    @ManyToOne
    @JoinColumn(name = "IdTopic")
    private Topics topics;

    @ManyToOne
    @JoinColumn(name = "IdTypeQuestion")
    private QuestionType questionType;


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

    public QuestionType getQuestionType() {
        return questionType;
    }

    public void setQuestionType(QuestionType questionType) {
        this.questionType = questionType;
    }
}
