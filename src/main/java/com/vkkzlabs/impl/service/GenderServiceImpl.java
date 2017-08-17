package com.vkkzlabs.impl.service;

import com.vkkzlabs.api.dao.GenderDAO;
import com.vkkzlabs.api.entity.Gender;
import com.vkkzlabs.api.service.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenderServiceImpl implements GenderService{
    @Autowired
    GenderDAO genderDAO;

    @Override
    public void saveGender(Gender gender) {
        genderDAO.save(gender);
    }

    @Override
    public Gender getGenderById(int idGender) {
        return genderDAO.getByIdGender(idGender);
    }
}
