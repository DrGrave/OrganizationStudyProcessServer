package com.vkkzlabs.service;

import com.vkkzlabs.entity.TypeOfAnswer;

/**
 * Created by vadim on 11.07.17.
 */
public interface TypeOfAnswerService {
    void saveTypeOfAnswer(TypeOfAnswer typeOfAnswer);
    TypeOfAnswer getTypeOfAnswerByIdTypeOfAnswer(int idTypeOfAnswer);
}
