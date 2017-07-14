package com.vkkzlabs.service.Impl;

import com.vkkzlabs.dao.TypeOfAnswerDAO;
import com.vkkzlabs.entity.TypeOfAnswer;
import com.vkkzlabs.service.TypeOfAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
