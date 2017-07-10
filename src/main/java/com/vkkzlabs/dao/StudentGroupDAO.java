package com.vkkzlabs.dao;

import com.vkkzlabs.entity.StudentGroup;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Vadim on 10.07.2017.
 */
public interface StudentGroupDAO extends CrudRepository<StudentGroup, Long>{
    StudentGroup getByIdGroup(int idGroup);
}
