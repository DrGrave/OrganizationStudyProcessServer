package com.vkkzlabs.service;

import com.vkkzlabs.entity.UserType;

public interface UserTypeService {
    void saveUserType(UserType userType);
    UserType getUserTypeByID(int id);
}
