package com.vkkzlabs.service.Impl;


import com.vkkzlabs.dao.UniversityDAO;
import com.vkkzlabs.entity.University;
import com.vkkzlabs.service.UniversityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
