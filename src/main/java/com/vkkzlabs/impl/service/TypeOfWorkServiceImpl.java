package com.vkkzlabs.impl.service;

import com.vkkzlabs.api.dao.TypeOfWorkDAO;
import com.vkkzlabs.api.entity.TypeOfWork;
import com.vkkzlabs.api.service.TypeOfWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *  Сервис для работы с типами работ
 */

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

    @Override
    public List<TypeOfWork> getAllTypesOfWork() {
        return typeOfWorkDAO.findAll();
    }
}
