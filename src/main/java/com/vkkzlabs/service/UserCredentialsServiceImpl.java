package com.vkkzlabs.service;

import com.vkkzlabs.dao.UserCredentialsDAO;
import com.vkkzlabs.entity.UserCredentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserCredentialsServiceImpl implements UserCredentialsService{
    @Autowired
    private UserCredentialsDAO userCredentialsDAO;

    @Override
    public UserCredentials getCtredById(int id) {
        return userCredentialsDAO.findByUserCredentialsID(id);
    }
}
