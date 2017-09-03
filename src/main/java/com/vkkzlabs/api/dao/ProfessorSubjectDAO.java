package com.vkkzlabs.api.dao;

import com.vkkzlabs.api.entity.M2MProfessorSubject;
import com.vkkzlabs.api.entity.Subject;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Vadim on 10.07.2017.
 */
public interface ProfessorSubjectDAO extends CrudRepository<M2MProfessorSubject, Long>{
    M2MProfessorSubject getByIdM2MProfessorSubject(int idProfessorSubject);
    List<M2MProfessorSubject> findAllByIdUser_IdUser(int idUser);
}
