package com.vkkzlabs.service;


import com.vkkzlabs.entity.M2MQuestionWork;

public interface QuestionWorkService {
    void saveQuestionWork(M2MQuestionWork questionWork);
    M2MQuestionWork getQuestionWorkByIdQuestionWork(int idQuestionWork);
}
