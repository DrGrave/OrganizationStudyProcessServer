package com.vkkzlabs.entity;

import javax.persistence.*;

/**
 * Created by Vadim on 08.07.2017.
 */
@Entity
@Table(name = "M2MQuestionWork")
public class M2MQuestionWork {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private
    int idM2MQuestionWork;

    @ManyToOne
    @JoinColumn(name = "idWork")
    private Work work;

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
