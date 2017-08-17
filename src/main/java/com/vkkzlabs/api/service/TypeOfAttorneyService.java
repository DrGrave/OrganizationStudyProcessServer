package com.vkkzlabs.api.service;

import com.vkkzlabs.api.entity.TypeOfAttorney;

/**
 * Created by vadim on 11.07.17.
 */
public interface TypeOfAttorneyService {
    void saveTypeOfAttorney(TypeOfAttorney typeOfAttorney);
    TypeOfAttorney getTypeOfAttorneyByIdTypeOfAttorney(int idTypeOfAttorney);
}
