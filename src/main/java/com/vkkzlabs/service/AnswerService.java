package com.vkkzlabs.service;

import com.vkkzlabs.entity.Answer;


public interface AnswerService {
    void saveAnswer(Answer answer);
    Answer getAnswerByIdAnswer(int answerId);
}
