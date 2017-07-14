package com.vkkzlabs.service.Impl;

import com.vkkzlabs.dao.AttorneyDAO;
import com.vkkzlabs.entity.Attorney;
import com.vkkzlabs.service.AttorneyService;
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
