package com.vkkzlabs.api.dao;

import com.vkkzlabs.api.entity.UserType;
import org.springframework.data.repository.CrudRepository;


public interface UserTypeDAO extends CrudRepository<UserType, Long> {
    UserType findByIdUserType(int id);
}
