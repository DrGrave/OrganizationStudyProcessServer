package com.vkkzlabs.impl.service;

import com.vkkzlabs.api.dao.TypeOfAttorneyDAO;
import com.vkkzlabs.api.entity.TypeOfAttorney;
import com.vkkzlabs.api.service.TypeOfAttorneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypeOfAttorneyServiceImpl implements TypeOfAttorneyService {
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
