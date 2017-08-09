package com.vkkzlabs.dao;

import com.vkkzlabs.entity.SubjectSupportFile;
import org.springframework.data.repository.CrudRepository;

public interface SubjectSupportFileDAO extends CrudRepository<SubjectSupportFile, Long>{
    SubjectSupportFile findBySubject_IdSubject(int idSubject);
}
