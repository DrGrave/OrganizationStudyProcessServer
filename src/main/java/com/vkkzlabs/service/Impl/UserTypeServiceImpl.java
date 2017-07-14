package com.vkkzlabs.service.Impl;


import com.vkkzlabs.dao.UserTypeDAO;
import com.vkkzlabs.entity.UserType;
import com.vkkzlabs.service.UserTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserTypeServiceImpl implements UserTypeService {
    @Autowired
    private UserTypeDAO userTypeDao;

    @Override
    public void saveUserType(UserType userType) {
        userTypeDao.save(userType);
    }

    @Override
    public UserType getUserTypeByID(int id) {
        return userTypeDao.findByIdUserType(id);
    }
}
