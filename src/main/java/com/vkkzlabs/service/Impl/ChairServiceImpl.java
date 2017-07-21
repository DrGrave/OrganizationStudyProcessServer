package com.vkkzlabs.service.Impl;

import com.vkkzlabs.dao.ChairDAO;
import com.vkkzlabs.entity.Chair;
import com.vkkzlabs.service.ChairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChairServiceImpl implements ChairService{
    @Autowired
    private ChairDAO chairDAO;

    @Override
    public void saveChair(Chair chair) {
        chairDAO.save(chair);
    }

    @Override
    public Chair getChairById(int idChair) {
        return chairDAO.getByIdChair(idChair);
    }
}
