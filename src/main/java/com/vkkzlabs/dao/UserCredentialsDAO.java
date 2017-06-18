package com.vkkzlabs.dao;

import com.vkkzlabs.entity.UserCredentials;
import org.springframework.data.repository.CrudRepository;


public interface UserCredentialsDAO extends CrudRepository<UserCredentials, Long> {
    UserCredentials findByUserCredentialsID(int id);
}
