package com.vkkzlabs.service;

import com.vkkzlabs.entity.MyUserCredentials;


public interface UserCredentialsService {
    void saveUserCredentials(MyUserCredentials userCredentials);
    MyUserCredentials getCtredById(int id);
    MyUserCredentials getUserByLogin(String login);
}
