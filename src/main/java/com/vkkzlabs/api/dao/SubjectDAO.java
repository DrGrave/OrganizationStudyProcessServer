package com.vkkzlabs.api.dao;

import com.vkkzlabs.api.entity.Subject;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Vadim on 10.07.2017.
 */
public interface SubjectDAO extends CrudRepository<Subject, Long>{
    Subject getByIdSubject(int idSubject);
}
