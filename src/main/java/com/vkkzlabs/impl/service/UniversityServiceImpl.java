package com.vkkzlabs.impl.service;


import com.vkkzlabs.api.dao.UniversityDAO;
import com.vkkzlabs.api.entity.University;
import com.vkkzlabs.api.service.UniversityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *  Сервис для работы с университетом
 */

@Service
public class UniversityServiceImpl implements UniversityService {
    @Autowired
    private UniversityDAO universityDAO;

    @Override
    public void saveUniversity(University university) {
        universityDAO.save(university);
    }

    @Override
    public University getUniversityById(int idUniversity) {
        return universityDAO.getByIdUniversity(idUniversity);
    }
}
