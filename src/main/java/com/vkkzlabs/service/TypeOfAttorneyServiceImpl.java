package com.vkkzlabs.service;

import com.vkkzlabs.dao.TypeOfAnswerDAO;
import com.vkkzlabs.dao.TypeOfAttorneyDAO;
import com.vkkzlabs.entity.TypeOfAttorney;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypeOfAttorneyServiceImpl implements TypeOfAttorneyService{
    @Autowired
    private TypeOfAttorneyDAO typeOfAttorneyDAO;

    @Override
    public void saveTypeOfAttorney(TypeOfAttorney typeOfAttorney) {
        typeOfAttorneyDAO.save(typeOfAttorney);
    }

    @Override
    public TypeOfAttorney getTypeOfAttorneyByIdTypeOfAttorney(int idTypeOfAttorney) {
        return typeOfAttorneyDAO.getByIdTypeOfAttorney(idTypeOfAttorney);
    }
}
