package com.vkkzlabs.api.dao;

import com.vkkzlabs.api.entity.MyUser;
import org.springframework.data.repository.CrudRepository;


public interface UserDAO extends CrudRepository<MyUser, Long> {
    MyUser getByIdUser(int id);
}
