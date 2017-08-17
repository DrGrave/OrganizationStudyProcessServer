package com.vkkzlabs.api.dao;


import com.vkkzlabs.api.entity.Faculty;
import org.springframework.data.repository.CrudRepository;

public interface FacultyDAO extends CrudRepository<Faculty, Long>{
    Faculty getByIdFaculty(int idFaculty);
}
