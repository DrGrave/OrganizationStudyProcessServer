package com.vkkzlabs.impl.service;

import com.vkkzlabs.api.dao.TypeOfAnswerDAO;
import com.vkkzlabs.api.entity.TypeOfAnswer;
import com.vkkzlabs.api.service.TypeOfAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *  Сервис для работы с типом ответа
 */

@Service
public class TypeOfAnswerServiceImpl implements TypeOfAnswerService {
    @Autowired
    private TypeOfAnswerDAO typeOfAnswerDAO;

    @Override
    public void saveTypeOfAnswer(TypeOfAnswer typeOfAnswer) {
        typeOfAnswerDAO.save(typeOfAnswer);
    }

    @Override
    public TypeOfAnswer getTypeOfAnswerByIdTypeOfAnswer(int idTypeOfAnswer) {
        return typeOfAnswerDAO.getByIdTypeOfAnswer(idTypeOfAnswer);
    }
}
