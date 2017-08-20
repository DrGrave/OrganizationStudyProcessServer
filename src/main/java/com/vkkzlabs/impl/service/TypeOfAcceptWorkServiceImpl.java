package com.vkkzlabs.impl.service;

import com.vkkzlabs.api.dao.TypeOfAcceptWorkDAO;
import com.vkkzlabs.api.entity.TypeOfAcceptWork;
import com.vkkzlabs.api.service.TypeOfAcceptWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *  Сервис для работы с типами принятых работ
 */

@Service
public class TypeOfAcceptWorkServiceImpl implements TypeOfAcceptWorkService {
    @Autowired
    private TypeOfAcceptWorkDAO typeOfAcceptWorkDAO;

    @Override
    public void saveTypeOfAcceptWork(TypeOfAcceptWork typeOfAcceptWork) {
        typeOfAcceptWorkDAO.save(typeOfAcceptWork);
    }

    @Override
    public TypeOfAcceptWork getTypeOfAcceptWorkByIdAcceptWork(int idAcceptWork) {
        return typeOfAcceptWorkDAO.getByIdOfAccaptWork(idAcceptWork);
    }
}
