package com.vkkzlabs.service;

import com.vkkzlabs.dao.AttorneyDAO;
import com.vkkzlabs.entity.Attorney;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttorneyServiceImpl implements AttorneyService {
    @Autowired
    private AttorneyDAO attorneyDAO;

    @Override
    public Attorney getAttorneyByIdAttorney(int idAttorney) {
        return attorneyDAO.getByIdAttorney(idAttorney);
    }
}
