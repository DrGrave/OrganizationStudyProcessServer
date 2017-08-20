package com.vkkzlabs.impl.service;

import com.vkkzlabs.api.dao.TypeInClassDAO;
import com.vkkzlabs.api.entity.TypeInClass;
import com.vkkzlabs.api.service.TypeInClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *  Сервис для работы с типами посещений пар
 */

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
