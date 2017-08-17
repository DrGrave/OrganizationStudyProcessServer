package com.vkkzlabs.api.service;

import com.vkkzlabs.api.entity.MyUserCredentials;


public interface UserCredentialsService {
    void saveUserCredentials(MyUserCredentials userCredentials);
    MyUserCredentials getCtredById(int id);
    MyUserCredentials getUserByLogin(String login);
}
