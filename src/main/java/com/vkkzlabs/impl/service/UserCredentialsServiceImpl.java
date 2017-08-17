package com.vkkzlabs.impl.service;

import com.vkkzlabs.api.dao.UserCredentialsDAO;
import com.vkkzlabs.api.entity.MyUserCredentials;
import com.vkkzlabs.api.service.UserCredentialsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *  Сервис для работы с пользовательскими данными
 */

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
