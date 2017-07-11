package com.vkkzlabs.service;

import com.vkkzlabs.dao.StudentGroupDAO;
import com.vkkzlabs.entity.StudentGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentGroupServiceImpl implements StudentGroupService{
    @Autowired
    private StudentGroupDAO studentGroupDAO;

    @Override
    public StudentGroup getStudentGroupByIdStudentGroup(int idStudentGroup) {
        return studentGroupDAO.getByIdGroup(idStudentGroup);
    }

}
