package com.vkkzlabs.service;

import com.vkkzlabs.entity.TypeOfQuestion;

/**
 * Created by vadim on 11.07.17.
 */
public interface TypeOfQuestionService {
    void saveTypeOfQuestion(TypeOfQuestion typeOfQuestion);
    TypeOfQuestion getTypeOfQuestionByIdTypeOfQuestion(int idTypeOfQuestion);
}
