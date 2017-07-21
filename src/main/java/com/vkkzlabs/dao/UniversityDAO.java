package com.vkkzlabs.dao;


import com.vkkzlabs.entity.University;
import org.springframework.data.repository.CrudRepository;

public interface UniversityDAO extends CrudRepository<University, Long>{
    University getByIdUniversity(int idUniversity);
}
