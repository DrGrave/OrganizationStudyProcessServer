package com.vkkzlabs.impl.service;

import com.vkkzlabs.api.dao.ProfessorSubjectDAO;
import com.vkkzlabs.api.entity.M2MProfessorSubject;
import com.vkkzlabs.api.entity.Subject;
import com.vkkzlabs.api.service.ProfessorSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 *  Сервис для работы с связью профессора и его предметами
 */

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

    @Override
    public List<Subject> getAllSubjects(Integer id) {
        List<Subject> list = new ArrayList<>();
        for (M2MProfessorSubject m2MProfessorSubject : professorSubjectDAO.findAllByIdUser_IdUser(id)){
            list.add(m2MProfessorSubject.getIdSubject());
        }
        return list;
    }


}
