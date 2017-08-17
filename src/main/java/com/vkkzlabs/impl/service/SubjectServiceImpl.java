package com.vkkzlabs.impl.service;

import com.vkkzlabs.api.dao.SubjectDAO;
import com.vkkzlabs.api.entity.Subject;
import com.vkkzlabs.api.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectServiceImpl implements SubjectService {
    @Autowired
    private SubjectDAO subjectDAO;

    @Override
    public void saveSubject(Subject subject) {
        subjectDAO.save(subject);
    }

    @Override
    public Subject getSubjectByIdSubject(int idSubject) {
        return subjectDAO.getByIdSubject(idSubject);
    }
}
