package com.vkkzlabs.service;

import com.vkkzlabs.dao.TypeOfQuestionDAO;
import com.vkkzlabs.entity.TypeOfQuestion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypeOfQuestionServiceImpl implements TypeOfQuestionService{
    @Autowired
    private TypeOfQuestionDAO typeOfQuestionDAO;

    @Override
    public TypeOfQuestion getTypeOfQuestionByIdTypeOfQuestion(int idTypeOfQuestion) {
        return typeOfQuestionDAO.getByIdTypeOfQuestion(idTypeOfQuestion);
    }
}
