package com.vkkzlabs.dao;

import com.vkkzlabs.entity.MyUser;
import com.vkkzlabs.entity.UserType;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Vadim on 20.06.2017.
 */
public interface UserDAO extends CrudRepository<MyUser, Long> {
    MyUser getByIdUser(int id);
}
