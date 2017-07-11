package com.vkkzlabs.service;

import com.vkkzlabs.dao.ProfessorSubjectDAO;
import com.vkkzlabs.entity.M2MProfessorSubject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfessorSubjectServiceImpl implements ProfessorSubjectService {
    @Autowired
    ProfessorSubjectDAO professorSubjectDAO;

    @Override
    public M2MProfessorSubject getProfessorSubjectByIdProfessorSubject(int idProfessorSubject) {
        return professorSubjectDAO.getByIdM2MProfessorSubject(idProfessorSubject);
    }
}
