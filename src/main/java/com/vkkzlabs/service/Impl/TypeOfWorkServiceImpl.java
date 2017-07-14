package com.vkkzlabs.service.Impl;

import com.vkkzlabs.dao.TypeOfWorkDAO;
import com.vkkzlabs.entity.TypeOfWork;
import com.vkkzlabs.service.TypeOfWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypeOfWorkServiceImpl implements TypeOfWorkService {
    @Autowired
    private TypeOfWorkDAO typeOfWorkDAO;

    @Override
    public void saveTypeOfWork(TypeOfWork typeOfWork) {
        typeOfWorkDAO.save(typeOfWork);
    }

    @Override
    public TypeOfWork getTypeOfWorkByIdTypeOfWork(int idTypeOfWork) {
        return typeOfWorkDAO.getByIdTypeOfWOrk(idTypeOfWork);
    }
}
