package com.vkkzlabs.service;

import com.vkkzlabs.dao.TypeOfWorkDAO;
import com.vkkzlabs.entity.TypeOfWork;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypeOfWorkServiceImpl implements TypeOfWorkService{
    @Autowired
    private TypeOfWorkDAO typeOfWorkDAO;

    @Override
    public TypeOfWork getTypeOfWorkByIdTypeOfWork(int idTypeOfWork) {
        return typeOfWorkDAO.getByIdTypeOfWOrk(idTypeOfWork);
    }
}
