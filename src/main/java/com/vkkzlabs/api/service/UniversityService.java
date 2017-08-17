package com.vkkzlabs.api.service;


import com.vkkzlabs.api.entity.University;

public interface UniversityService {
    void saveUniversity(University university);
    University getUniversityById(int idUniversity);
}
