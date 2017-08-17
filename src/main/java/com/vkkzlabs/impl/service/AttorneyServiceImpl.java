package com.vkkzlabs.impl.service;

import com.vkkzlabs.api.dao.AttorneyDAO;
import com.vkkzlabs.api.entity.Attorney;
import com.vkkzlabs.api.service.AttorneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttorneyServiceImpl implements AttorneyService {
    @Autowired
    private AttorneyDAO attorneyDAO;

    @Override
    public void saveAttorney(Attorney attorney) {
        attorneyDAO.save(attorney);
    }

    @Override
    public Attorney getAttorneyByIdAttorney(int idAttorney) {
        return attorneyDAO.getByIdAttorney(idAttorney);
    }
}
