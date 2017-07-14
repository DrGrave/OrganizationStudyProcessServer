package com.vkkzlabs.service.Impl;

import com.vkkzlabs.dao.UserCredentialsDAO;
import com.vkkzlabs.entity.MyUserCredentials;
import com.vkkzlabs.service.UserCredentialsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserCredentialsServiceImpl implements UserCredentialsService {
    @Autowired
    private UserCredentialsDAO userCredentialsDAO;

    @Override
    public void saveUserCredentials(MyUserCredentials userCredentials) {
        userCredentialsDAO.save(userCredentials);
    }

    @Override
    public MyUserCredentials getCtredById(int id) {
        return userCredentialsDAO.findByIdUserCredential(id);
    }

    @Override
    public MyUserCredentials getUserByLogin(String login) {
        return userCredentialsDAO.findByUserLogin(login);
    }
}
