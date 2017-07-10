package com.vkkzlabs.dao;

import com.vkkzlabs.entity.M2MStudentWork;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Vadim on 10.07.2017.
 */
public interface StudentWorkDAO extends CrudRepository<M2MStudentWork, Long>{
    M2MStudentWork getByIdM2MStudentWork(int idStudentWork);
}
