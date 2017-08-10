package com.vkkzlabs.dao;

import com.vkkzlabs.entity.SubjectSupportFile;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SubjectSupportFileDAO extends CrudRepository<SubjectSupportFile, Long>{
    List<SubjectSupportFile> findAllBySubject_IdSubject(int idSubject);
}
