package com.vkkzlabs.service.Impl;

import com.vkkzlabs.dao.TypeOfAcceptWorkDAO;
import com.vkkzlabs.entity.TypeOfAcceptWork;
import com.vkkzlabs.service.TypeOfAcceptWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
