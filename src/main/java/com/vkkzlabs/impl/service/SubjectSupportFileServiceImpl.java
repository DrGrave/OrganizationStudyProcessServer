package com.vkkzlabs.impl.service;

import com.vkkzlabs.api.dao.SubjectSupportFileDAO;
import com.vkkzlabs.api.entity.SubjectSupportFile;
import com.vkkzlabs.api.service.SubjectSupportFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectSupportFileServiceImpl implements SubjectSupportFileService {
    @Autowired
    SubjectSupportFileDAO subjectSupportFileDAO;

    @Override
    public void saveSubjectSupportFile(SubjectSupportFile file) {
        subjectSupportFileDAO.save(file);
    }

    @Override
    public List<SubjectSupportFile> getListSubjectSupportFileByIdSubject(int idSubject) {
        return subjectSupportFileDAO.findAllBySubject_IdSubject(idSubject);
    }

    @Override
    public SubjectSupportFile getSubjectSupportFileByIdSupFile(int idSupFile) {
        return subjectSupportFileDAO.findByIdSubjectSupportFile(idSupFile);
    }
}
