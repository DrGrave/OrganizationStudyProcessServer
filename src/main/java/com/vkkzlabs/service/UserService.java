package com.vkkzlabs.service;

import com.vkkzlabs.entity.MyUser;

/**
 * Created by Vadim on 20.06.2017.
 */
public interface UserService {
    void saveUser(MyUser myUser);
    MyUser getUserById(int id);
}
