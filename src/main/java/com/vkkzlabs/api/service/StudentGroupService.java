package com.vkkzlabs.api.service;

import com.vkkzlabs.api.entity.StudentGroup;

import java.util.List;

/**
 * Created by vadim on 11.07.17.
 */
public interface StudentGroupService {
    void saveStudentGroup(StudentGroup studentGroup);
    StudentGroup getStudentGroupByIdStudentGroup(int idStudentGroup);

    List<StudentGroup> getListStudentGroupsToProfessor(int idProfessor);
}
