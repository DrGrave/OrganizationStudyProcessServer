package com.vkkzlabs.service;

import com.vkkzlabs.entity.M2MStudentWork;
import com.vkkzlabs.entity.Subject;

import java.util.List;

/**
 * Created by vadim on 11.07.17.
 */
public interface StudentWorkService {
    void saveStudentWork(M2MStudentWork studentWork);
    M2MStudentWork getStudentWorkByIdStudentWork(int idStudentWork);

    List<M2MStudentWork> getListSubjectsToStudent(int id);
}
