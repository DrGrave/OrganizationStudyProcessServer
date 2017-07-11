package com.vkkzlabs.service;

import com.vkkzlabs.dao.StudentWorkDAO;
import com.vkkzlabs.entity.M2MStudentWork;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentWorkServiceImpl implements StudentWorkService {
    @Autowired
    private StudentWorkDAO studentWorkDAO;

    @Override
    public M2MStudentWork getStudentWorkByIdStudentWork(int idStudentWork) {
        return studentWorkDAO.getByIdM2MStudentWork(idStudentWork);
    }
}
