package com.vkkzlabs.api.dao;


import com.vkkzlabs.api.entity.University;
import org.springframework.data.repository.CrudRepository;

public interface UniversityDAO extends CrudRepository<University, Long>{
    University getByIdUniversity(int idUniversity);
}
