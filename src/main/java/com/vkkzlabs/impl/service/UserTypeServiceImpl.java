package com.vkkzlabs.impl.service;


import com.vkkzlabs.api.dao.UserTypeDAO;
import com.vkkzlabs.api.entity.UserType;
import com.vkkzlabs.api.service.UserTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *  Сервис для работы с типами пользователей
 */

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
