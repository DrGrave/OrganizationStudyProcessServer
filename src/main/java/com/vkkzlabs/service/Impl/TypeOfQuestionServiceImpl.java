package com.vkkzlabs.service.Impl;

import com.vkkzlabs.dao.TypeOfQuestionDAO;
import com.vkkzlabs.entity.TypeOfQuestion;
import com.vkkzlabs.service.TypeOfQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
