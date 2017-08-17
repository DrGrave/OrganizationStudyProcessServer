package com.vkkzlabs.impl.service;

import com.vkkzlabs.api.dao.QuestionWorkDAO;
import com.vkkzlabs.api.entity.M2MQuestionWork;
import com.vkkzlabs.api.service.QuestionWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *  Сервис для работы со связью работ и вопросов
 */

@Service
public class QuestionWorkServiceImpl implements QuestionWorkService {
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
