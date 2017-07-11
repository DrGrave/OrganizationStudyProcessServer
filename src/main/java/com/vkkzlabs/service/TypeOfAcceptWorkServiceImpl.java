package com.vkkzlabs.service;

import com.vkkzlabs.dao.TypeOfAcceptWorkDAO;
import com.vkkzlabs.entity.TypeOfAcceptWork;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypeOfAcceptWorkServiceImpl implements TypeOfAcceptWorkService{
    @Autowired
    private TypeOfAcceptWorkDAO typeOfAcceptWorkDAO;

    @Override
    public TypeOfAcceptWork getTypeOfAcceptWorkByIdAcceptWork(int idAcceptWork) {
        return typeOfAcceptWorkDAO.getByIdOfAccaptWork(idAcceptWork);
    }
}
