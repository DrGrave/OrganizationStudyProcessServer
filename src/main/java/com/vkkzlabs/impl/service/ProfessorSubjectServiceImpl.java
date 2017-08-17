package com.vkkzlabs.impl.service;

import com.vkkzlabs.api.dao.ProfessorSubjectDAO;
import com.vkkzlabs.api.entity.M2MProfessorSubject;
import com.vkkzlabs.api.service.ProfessorSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfessorSubjectServiceImpl implements ProfessorSubjectService {
    @Autowired
    private ProfessorSubjectDAO professorSubjectDAO;

    @Override
    public void saveProfessorSubject(M2MProfessorSubject professorSubject) {
        professorSubjectDAO.save(professorSubject);
    }

    @Override
    public M2MProfessorSubject getProfessorSubjectByIdProfessorSubject(int idProfessorSubject) {
        return professorSubjectDAO.getByIdM2MProfessorSubject(idProfessorSubject);
    }
}
