package com.vkkzlabs.api.service;


import com.vkkzlabs.api.entity.M2MQuestionWork;

public interface QuestionWorkService {
    void saveQuestionWork(M2MQuestionWork questionWork);
    M2MQuestionWork getQuestionWorkByIdQuestionWork(int idQuestionWork);
}
