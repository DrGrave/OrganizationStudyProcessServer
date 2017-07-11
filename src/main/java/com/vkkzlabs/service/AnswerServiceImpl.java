package com.vkkzlabs.service;

import com.vkkzlabs.dao.AnswerDAO;
import com.vkkzlabs.entity.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswerServiceImpl implements AnswerService {
    @Autowired
    AnswerDAO answerDAO;

    @Override
    public Answer getAnswerByIdAnswer(int answerId) {
        return answerDAO.getByIdAnswer(answerId);
    }
}
