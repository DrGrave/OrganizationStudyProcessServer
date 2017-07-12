package com.vkkzlabs.service;

import com.vkkzlabs.entity.Answer;

/**
 * Created by vadim on 11.07.17.
 */
public interface AnswerService {
    void saveAnswer(Answer answer);
    Answer getAnswerByIdAnswer(int answerId);
}
