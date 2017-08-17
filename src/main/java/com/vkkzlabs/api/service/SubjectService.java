package com.vkkzlabs.api.service;

import com.vkkzlabs.api.entity.Subject;

/**
 * Created by vadim on 11.07.17.
 */
public interface SubjectService {
    void saveSubject(Subject subject);
    Subject getSubjectByIdSubject(int idSubject);
}
