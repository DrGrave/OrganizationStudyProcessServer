package com.vkkzlabs.impl.service;

import com.vkkzlabs.api.dao.QuestionDAO;
import com.vkkzlabs.api.entity.Question;
import com.vkkzlabs.api.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionDAO questionDAO;

    @Override
    public void saveQuestion(Question question) {
        questionDAO.save(question);
    }

    @Override
    public Question getQuestionByIdQuestion(int idQuestion) {
        return questionDAO.getByIdQuestion(idQuestion);
    }
}
