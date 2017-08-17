package com.vkkzlabs.impl.service;

import com.vkkzlabs.api.dao.StudentGroupDAO;
import com.vkkzlabs.api.entity.StudentGroup;
import com.vkkzlabs.api.service.StudentGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *  Сервис для работы со связью студентов и их групп
 */

@Service
public class StudentGroupServiceImpl implements StudentGroupService {
    @Autowired
    private StudentGroupDAO studentGroupDAO;

    @Override
    public void saveStudentGroup(StudentGroup studentGroup) {
        studentGroupDAO.save(studentGroup);
    }

    @Override
    public StudentGroup getStudentGroupByIdStudentGroup(int idStudentGroup) {
        return studentGroupDAO.getByIdGroup(idStudentGroup);
    }

}
