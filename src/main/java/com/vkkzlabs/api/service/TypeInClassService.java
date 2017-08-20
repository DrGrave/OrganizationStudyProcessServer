package com.vkkzlabs.api.service;

import com.vkkzlabs.api.entity.TypeInClass;

/**
 * Created by vadim on 11.07.17.
 */
public interface TypeInClassService {
    void saveTypeInClass(TypeInClass typeInClass);
    TypeInClass getTypeInClassByIdTypeInClass(int idTypeInClass);
}
