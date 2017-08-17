package com.vkkzlabs.api.dao;

import com.vkkzlabs.api.entity.MyUserCredentials;
import org.springframework.data.repository.CrudRepository;



public interface UserCredentialsDAO extends CrudRepository<MyUserCredentials, Long> {
    MyUserCredentials findByIdUserCredential(int id);
    MyUserCredentials findByUserLogin(String login);
}
