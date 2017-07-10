package com.vkkzlabs.dao;

import com.vkkzlabs.entity.MyUser;
import com.vkkzlabs.entity.UserType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface UserDAO extends CrudRepository<MyUser, Long> {
    MyUser getByIdUser(int id);
}
