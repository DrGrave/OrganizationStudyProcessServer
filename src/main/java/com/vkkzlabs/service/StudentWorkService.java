package com.vkkzlabs.service;

import com.vkkzlabs.entity.M2MStudentWork;

/**
 * Created by vadim on 11.07.17.
 */
public interface StudentWorkService {
    void saveStudentWork(M2MStudentWork studentWork);
    M2MStudentWork getStudentWorkByIdStudentWork(int idStudentWork);
}
