package com.vkkzlabs.api.service;


import com.vkkzlabs.api.entity.M2MProfessorSubject;
import com.vkkzlabs.api.entity.Subject;

import java.util.List;

public interface ProfessorSubjectService {
    void saveProfessorSubject(M2MProfessorSubject professorSubject);
    M2MProfessorSubject getProfessorSubjectByIdProfessorSubject(int idProfessorSubject);

    List<Subject> getAllSubjects(Integer id);
}
