package com.vkkzlabs.api.dao;

import com.vkkzlabs.api.entity.StudentGroup;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Vadim on 10.07.2017.
 */
public interface StudentGroupDAO extends CrudRepository<StudentGroup, Long>{
    StudentGroup getByIdGroup(int idGroup);
    List<StudentGroup> findAll();
}
