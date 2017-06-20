package com.vkkzlabs.service;

import com.vkkzlabs.dao.UserCredentialsDAO;
import com.vkkzlabs.entity.MyUserCredentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserCredentialsServiceImpl implements UserCredentialsService{
    @Autowired
    private UserCredentialsDAO userCredentialsDAO;

    @Override
    public MyUserCredentials getCtredById(int id) {
        return userCredentialsDAO.findByIdUserCredential(id);
    }

    @Override
    public MyUserCredentials getUserByLogin(String login) {
        return userCredentialsDAO.findByUserLogin(login);
    }
}
