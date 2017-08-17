package com.vkkzlabs.api.service;


import com.vkkzlabs.api.entity.Faculty;

public interface FacultyService {
    void saveFaculty(Faculty faculty);
    Faculty getFacultyById(int idFaculty);
}
