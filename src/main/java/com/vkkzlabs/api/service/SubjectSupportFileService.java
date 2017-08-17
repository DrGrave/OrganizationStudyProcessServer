package com.vkkzlabs.api.service;

import com.vkkzlabs.api.entity.SubjectSupportFile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SubjectSupportFileService {
    void saveSubjectSupportFile(SubjectSupportFile file);
    List<SubjectSupportFile> getListSubjectSupportFileByIdSubject(int idSubject);
    SubjectSupportFile getSubjectSupportFileByIdSupFile(int idSupFile);
}
