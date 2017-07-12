package com.vkkzlabs.service;


import com.vkkzlabs.entity.M2MProfessorSubject;

public interface ProfessorSubjectService {
    void saveProfessorSubject(M2MProfessorSubject professorSubject);
    M2MProfessorSubject getProfessorSubjectByIdProfessorSubject(int idProfessorSubject);
}
