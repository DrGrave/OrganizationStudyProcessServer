package com.vkkzlabs.service;


import com.vkkzlabs.entity.University;

public interface UniversityService {
    void saveUniversity(University university);
    University getUniversityById(int idUniversity);
}
