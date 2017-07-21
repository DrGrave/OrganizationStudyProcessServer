package com.vkkzlabs.dao;


import com.vkkzlabs.entity.Faculty;
import org.springframework.data.repository.CrudRepository;

public interface FacultyDAO extends CrudRepository<Faculty, Long>{
    Faculty getByIdFaculty(int idFaculty);
}
