package com.vkkzlabs.service;


import com.vkkzlabs.dao.UserTypeDAO;
import com.vkkzlabs.entity.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserTypeServiceImpl implements UserTypeService {
    @Autowired
    private
    UserTypeDAO userTypeDao;

    @Override
    public UserType getUserTypeByID(int id) {
        return userTypeDao.findByIdUserType(id);
    }
}
