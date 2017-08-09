package com.vkkzlabs.service.Impl;

import com.vkkzlabs.dao.SubjectSupportFileDAO;
import com.vkkzlabs.entity.SubjectSupportFile;
import com.vkkzlabs.service.SubjectSupportFileService;
import org.springframework.beans.factory.annotation.Autowired;

public class SubjectSupportFileServiceImpl implements SubjectSupportFileService {
    @Autowired
    SubjectSupportFileDAO subjectSupportFileDAO;

    @Override
    public void saveSubjectSupportFile(SubjectSupportFile file) {
        subjectSupportFileDAO.save(file);
    }

    @Override
    public SubjectSupportFile getSubjectSupportFileByIdSubject(int idSubject) {
        return subjectSupportFileDAO.findBySubject_IdSubject(idSubject);
    }
}
