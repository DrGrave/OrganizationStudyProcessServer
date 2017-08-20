package com.vkkzlabs.api.service;

import com.vkkzlabs.api.entity.InClass;

public interface InClassService {
    void saveInClass(InClass inClass);
    InClass getInClassByIdInClass(int idInClass);
}
