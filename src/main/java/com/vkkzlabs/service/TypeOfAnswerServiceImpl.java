package com.vkkzlabs.service;

import com.vkkzlabs.dao.TypeOfAnswerDAO;
import com.vkkzlabs.entity.TypeOfAnswer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypeOfAnswerServiceImpl implements TypeOfAnswerService{
    @Autowired
    private TypeOfAnswerDAO typeOfAnswerDAO;

    @Override
    public TypeOfAnswer getTypeOfAnswerByIdTypeOfAnswer(int idTypeOfAnswer) {
        return typeOfAnswerDAO.getByIdTypeOfAnswer(idTypeOfAnswer);
    }
}
