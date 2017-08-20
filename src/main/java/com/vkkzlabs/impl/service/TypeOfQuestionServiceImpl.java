package com.vkkzlabs.impl.service;

import com.vkkzlabs.api.dao.TypeOfQuestionDAO;
import com.vkkzlabs.api.entity.TypeOfQuestion;
import com.vkkzlabs.api.service.TypeOfQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *  Сервис для работы с типами вопросов
 */

@Service
public class TypeOfQuestionServiceImpl implements TypeOfQuestionService {
    @Autowired
    private TypeOfQuestionDAO typeOfQuestionDAO;

    @Override
    public void saveTypeOfQuestion(TypeOfQuestion typeOfQuestion) {
        typeOfQuestionDAO.save(typeOfQuestion);
    }

    @Override
    public TypeOfQuestion getTypeOfQuestionByIdTypeOfQuestion(int idTypeOfQuestion) {
        return typeOfQuestionDAO.getByIdTypeOfQuestion(idTypeOfQuestion);
    }
}
