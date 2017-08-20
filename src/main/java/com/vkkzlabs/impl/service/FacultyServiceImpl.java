package com.vkkzlabs.impl.service;

import com.vkkzlabs.api.dao.FacultyDAO;
import com.vkkzlabs.api.entity.Faculty;
import com.vkkzlabs.api.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *  Сервис для работы с факультетами
 */

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
