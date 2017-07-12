package com.vkkzlabs.service;

import com.vkkzlabs.entity.TypeOfWork;



/**
 * Created by vadim on 11.07.17.
 */
public interface TypeOfWorkService {
    void saveTypeOfWork(TypeOfWork typeOfWork);
    TypeOfWork getTypeOfWorkByIdTypeOfWork(int idTypeOfWork);
}
