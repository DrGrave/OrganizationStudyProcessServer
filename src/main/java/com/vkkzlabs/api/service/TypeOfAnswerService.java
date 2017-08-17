package com.vkkzlabs.api.service;

import com.vkkzlabs.api.entity.TypeOfAnswer;

/**
 * Created by vadim on 11.07.17.
 */
public interface TypeOfAnswerService {
    void saveTypeOfAnswer(TypeOfAnswer typeOfAnswer);
    TypeOfAnswer getTypeOfAnswerByIdTypeOfAnswer(int idTypeOfAnswer);
}
