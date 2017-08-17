package com.vkkzlabs.api.service;

import com.vkkzlabs.api.entity.TypeOfAcceptWork;

/**
 * Created by vadim on 11.07.17.
 */
public interface TypeOfAcceptWorkService {
    void saveTypeOfAcceptWork(TypeOfAcceptWork typeOfAcceptWork);
    TypeOfAcceptWork getTypeOfAcceptWorkByIdAcceptWork(int idAcceptWork);
}
