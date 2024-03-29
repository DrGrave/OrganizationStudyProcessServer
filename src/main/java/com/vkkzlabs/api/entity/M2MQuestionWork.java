package com.vkkzlabs.api.entity;

import javax.persistence.*;

/**
 * Объект для связи вопроса и работы
 */

@Entity
@Table(name = "M2MQuestionWork")
public class M2MQuestionWork {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private
    int idM2MQuestionWork;

    /**
     * Объект работа
     */

    @ManyToOne
    @JoinColumn(name = "idWork")
    private Work work;

    /**
     * Объект вопрос
     */

    @ManyToOne
    @JoinColumn(name = "idQuestion")
    private Question question;

    public int getIdM2MQuestionWork() {
        return idM2MQuestionWork;
    }

    public void setIdM2MQuestionWork(int idM2MQuestionWork) {
        this.idM2MQuestionWork = idM2MQuestionWork;
    }

    public Work getWork() {
        return work;
    }

    public void setWork(Work work) {
        this.work = work;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
