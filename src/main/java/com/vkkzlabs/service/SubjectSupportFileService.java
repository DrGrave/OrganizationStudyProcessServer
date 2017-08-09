package com.vkkzlabs.service;

import com.vkkzlabs.entity.SubjectSupportFile;
import org.springframework.stereotype.Service;

@Service
public interface SubjectSupportFileService {
    void saveSubjectSupportFile(SubjectSupportFile file);
    SubjectSupportFile getSubjectSupportFileByIdSubject(int idSubject);
}
