package com.vkkzlabs.api.service;

import com.vkkzlabs.api.entity.Answer;


public interface AnswerService {
    void saveAnswer(Answer answer);
    Answer getAnswerByIdAnswer(int answerId);
}
