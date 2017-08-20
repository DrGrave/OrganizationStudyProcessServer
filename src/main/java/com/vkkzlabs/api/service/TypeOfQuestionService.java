package com.vkkzlabs.api.service;

import com.vkkzlabs.api.entity.TypeOfQuestion;

/**
 * Created by vadim on 11.07.17.
 */
public interface TypeOfQuestionService {
    void saveTypeOfQuestion(TypeOfQuestion typeOfQuestion);
    TypeOfQuestion getTypeOfQuestionByIdTypeOfQuestion(int idTypeOfQuestion);
}
