package com.vkkzlabs.api.dao;

import com.vkkzlabs.api.entity.SubjectSupportFile;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SubjectSupportFileDAO extends CrudRepository<SubjectSupportFile, Long>{
    List<SubjectSupportFile> findAllBySubject_IdSubject(int idSubject);
    SubjectSupportFile findByIdSubjectSupportFile(int idSubjSupFile);
}
