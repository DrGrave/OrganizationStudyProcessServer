package com.vkkzlabs.api.service;


import com.vkkzlabs.api.entity.M2MProfessorSubject;

public interface ProfessorSubjectService {
    void saveProfessorSubject(M2MProfessorSubject professorSubject);
    M2MProfessorSubject getProfessorSubjectByIdProfessorSubject(int idProfessorSubject);
}
