package com.vkkzlabs.service;

import com.vkkzlabs.dao.QuestionWorkDAO;
import com.vkkzlabs.entity.M2MQuestionWork;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionWorkServiceImpl implements QuestionWorkService{
    @Autowired
    private QuestionWorkDAO questionWorkDAO;

    @Override
    public void saveQuestionWork(M2MQuestionWork questionWork) {
        questionWorkDAO.save(questionWork);
    }

    @Override
    public M2MQuestionWork getQuestionWorkByIdQuestionWork(int idQuestionWork) {
        return questionWorkDAO.getByIdM2MQuestionWork(idQuestionWork);
    }
}