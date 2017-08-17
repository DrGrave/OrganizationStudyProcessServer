package com.vkkzlabs.impl.service;

import com.vkkzlabs.api.dao.AnswerDAO;
import com.vkkzlabs.api.entity.Answer;
import com.vkkzlabs.api.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswerServiceImpl implements AnswerService {
    @Autowired
    private AnswerDAO answerDAO;

    @Override
    public void saveAnswer(Answer answer) {
        answerDAO.save(answer);
    }

    @Override
    public Answer getAnswerByIdAnswer(int answerId) {
        return answerDAO.getByIdAnswer(answerId);
    }
}
