package com.vkkzlabs.service.Impl;

import com.vkkzlabs.dao.FacultyDAO;
import com.vkkzlabs.entity.Faculty;
import com.vkkzlabs.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacultyServiceImpl implements FacultyService{
    @Autowired
    private FacultyDAO facultyDAO;

    @Override
    public void saveFaculty(Faculty faculty) {
        facultyDAO.save(faculty);
    }

    @Override
    public Faculty getFacultyById(int idFaculty) {
        return facultyDAO.getByIdFaculty(idFaculty);
    }
}
