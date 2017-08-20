package com.vkkzlabs.api.service;

import com.vkkzlabs.api.entity.Question;

/**
 * Created by vadim on 11.07.17.
 */
public interface QuestionService {
    void saveQuestion(Question question);
    Question getQuestionByIdQuestion(int idQuestion);
}
