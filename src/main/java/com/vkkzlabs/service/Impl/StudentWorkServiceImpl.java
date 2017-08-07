package com.vkkzlabs.service.Impl;

import com.vkkzlabs.dao.StudentWorkDAO;
import com.vkkzlabs.entity.M2MStudentWork;
import com.vkkzlabs.entity.Subject;
import com.vkkzlabs.service.StudentWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentWorkServiceImpl implements StudentWorkService {
    @Autowired
    private StudentWorkDAO studentWorkDAO;

    @Override
    public void saveStudentWork(M2MStudentWork studentWork) {
        studentWorkDAO.save(studentWork);
    }

    @Override
    public M2MStudentWork getStudentWorkByIdStudentWork(int idStudentWork) {
        return studentWorkDAO.getByIdM2MStudentWork(idStudentWork);
    }

    @Override
    public List<M2MStudentWork> getListSubjectsToStudent(int idUser) {
        List<M2MStudentWork> works = studentWorkDAO.findAllByIdUser_IdUser(idUser);
        return works;
    }

    @Override
    public List<M2MStudentWork> getListWorksToStudent(int idUser, int idSubject) {
        List<M2MStudentWork> works = studentWorkDAO.findAllByIdOfWork_Subject_IdSubjectAndAndIdUser_IdUserOrderByIdOfAccaptWork(idSubject, idUser);
        return works;
    }

    @Override
    public void editStudentWork(M2MStudentWork m2MStudentWork) {
        studentWorkDAO.save(m2MStudentWork);
    }
}
