package com.vkkzlabs.service;

import com.vkkzlabs.entity.StudentGroup;

/**
 * Created by vadim on 11.07.17.
 */
public interface StudentGroupService {
    void saveStudentGroup(StudentGroup studentGroup);
    StudentGroup getStudentGroupByIdStudentGroup(int idStudentGroup);
}
