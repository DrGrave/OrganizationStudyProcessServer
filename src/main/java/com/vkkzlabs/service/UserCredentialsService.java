package com.vkkzlabs.service;

import com.vkkzlabs.entity.MyUserCredentials;

public interface UserCredentialsService {
    MyUserCredentials getCtredById(int id);
    MyUserCredentials getUserByLogin(String login);
}
