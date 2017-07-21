package com.vkkzlabs.service;


import com.vkkzlabs.entity.Faculty;

public interface FacultyService {
    void saveFaculty(Faculty faculty);
    Faculty getFacultyById(int idFaculty);
}
