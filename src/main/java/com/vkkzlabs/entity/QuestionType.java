package com.vkkzlabs.entity;

import javax.persistence.*;

/**
 * Created by Vadim on 08.07.2017.
 */
@Entity
@Table(name="QuestionType")
public class QuestionType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private
    int idQuestionType;

    @Column(name = "NameQuestionType")
    private String nameQuestionType;

    public int getIdQuestionType() {
        return idQuestionType;
    }

    public void setIdQuestionType(int idQuestionType) {
        this.idQuestionType = idQuestionType;
    }

    public String getNameQuestionType() {
        return nameQuestionType;
    }

    public void setNameQuestionType(String nameQuestionType) {
        this.nameQuestionType = nameQuestionType;
    }


}
