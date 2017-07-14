package com.vkkzlabs.service.Impl;

import com.vkkzlabs.dao.TypeInClassDAO;
import com.vkkzlabs.entity.TypeInClass;
import com.vkkzlabs.service.TypeInClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypeInClassServiceImpl implements TypeInClassService {
    @Autowired
    private TypeInClassDAO typeInClassDAO;

    @Override
    public void saveTypeInClass(TypeInClass typeInClass) {
        typeInClassDAO.save(typeInClass);
    }

    @Override
    public TypeInClass getTypeInClassByIdTypeInClass(int idTypeInClass) {
        return typeInClassDAO.getByIdTypeInClass(idTypeInClass);
    }
}
