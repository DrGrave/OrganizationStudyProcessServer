package com.vkkzlabs.api.dao;


import com.vkkzlabs.api.entity.Gender;
import org.springframework.data.repository.CrudRepository;

public interface GenderDAO extends CrudRepository<Gender, Long>{
    Gender getByIdGender(int idGender);
}
