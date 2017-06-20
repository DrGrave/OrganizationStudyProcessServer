package com.vkkzlabs.dao;

import com.vkkzlabs.entity.MyUserCredentials;
import org.springframework.data.repository.CrudRepository;



public interface UserCredentialsDAO extends CrudRepository<MyUserCredentials, Long> {
    MyUserCredentials findByIdUserCredential(int id);
    MyUserCredentials findByUserLogin(String login);
}
