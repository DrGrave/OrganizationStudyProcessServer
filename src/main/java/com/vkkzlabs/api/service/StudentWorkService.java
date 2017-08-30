package com.vkkzlabs.api.service;

import com.vkkzlabs.api.entity.M2MStudentWork;

import java.util.List;

/**
 * Created by vadim on 11.07.17.
 */
public interface StudentWorkService {
    void saveStudentWork(M2MStudentWork studentWork);
    M2MStudentWork getStudentWorkByIdStudentWork(int idStudentWork);

    List<M2MStudentWork> getListSubjectsToStudent(int id);

    List<M2MStudentWork> getListWorksToStudent(int idUser, int idSubject);

    void editStudentWork(M2MStudentWork m2MStudentWork);

    List<M2MStudentWork> getListOfNewWorks(int id);

    List<M2MStudentWork> getListOfAcceptedStudentWorks(int idUser, int idSubject);
}
