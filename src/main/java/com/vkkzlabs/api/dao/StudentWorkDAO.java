package com.vkkzlabs.api.dao;

import com.vkkzlabs.api.entity.M2MStudentWork;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Vadim on 10.07.2017.
 */
public interface StudentWorkDAO extends CrudRepository<M2MStudentWork, Long>{
    M2MStudentWork getByIdM2MStudentWork(int idStudentWork);

    List<M2MStudentWork> findAllByIdUser_IdUser(int idUser);

    List<M2MStudentWork> findAllByIdOfWork_Subject_IdSubjectAndAndIdUser_IdUserOrderByIdOfAccaptWork(int idSubject, int idUser);
}
