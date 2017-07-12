package com.vkkzlabs.service;

import com.vkkzlabs.dao.InClassDAO;
import com.vkkzlabs.entity.InClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InClassServiceImpl implements InClassService{
    @Autowired
    private InClassDAO inClassDAO;

    @Override
    public void saveInClass(InClass inClass) {
        inClassDAO.save(inClass);
    }

    @Override
    public InClass getInClassByIdInClass(int idInClass) {
        return inClassDAO.getByIdInClass(idInClass);
    }
}
