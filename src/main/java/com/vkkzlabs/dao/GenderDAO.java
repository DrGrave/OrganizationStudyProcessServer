package com.vkkzlabs.dao;


import com.vkkzlabs.entity.Gender;
import org.springframework.data.repository.CrudRepository;

public interface GenderDAO extends CrudRepository<Gender, Long>{
    Gender getByIdGender(int idGender);
}
