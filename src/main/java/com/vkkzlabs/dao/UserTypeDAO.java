package com.vkkzlabs.dao;

import com.vkkzlabs.entity.UserType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


public interface UserTypeDAO extends CrudRepository<UserType, Long> {
    UserType findByIdUserType(int id);
}
