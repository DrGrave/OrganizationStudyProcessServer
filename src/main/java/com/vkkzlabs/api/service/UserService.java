package com.vkkzlabs.api.service;

import com.vkkzlabs.api.entity.MyUser;

/**
 * Created by Vadim on 20.06.2017.
 */
public interface UserService {
    void saveUser(MyUser myUser);
    MyUser getUserById(int id);
}
