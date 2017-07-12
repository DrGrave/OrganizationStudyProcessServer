package com.vkkzlabs.service;

import com.vkkzlabs.dao.UserDAO;
import com.vkkzlabs.entity.MyUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDAO userDAO;

    @Override
    public void saveUser(MyUser myUser) {
        userDAO.save(myUser);
    }

    @Override
    public MyUser getUserById(int id) {
        return userDAO.getByIdUser(id);
    }
}
