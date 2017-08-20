package com.vkkzlabs.api.service;

import com.vkkzlabs.api.entity.UserType;

public interface UserTypeService {
    void saveUserType(UserType userType);
    UserType getUserTypeByID(int id);
}
