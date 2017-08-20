package com.vkkzlabs.api.dao;

import com.vkkzlabs.api.entity.M2MProfessorSubject;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Vadim on 10.07.2017.
 */
public interface ProfessorSubjectDAO extends CrudRepository<M2MProfessorSubject, Long>{
    M2MProfessorSubject getByIdM2MProfessorSubject(int idProfessorSubject);
}
