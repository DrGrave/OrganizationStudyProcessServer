package com.vkkzlabs.impl.service;

import com.vkkzlabs.api.dao.ChairDAO;
import com.vkkzlabs.api.entity.Chair;
import com.vkkzlabs.api.service.ChairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *  Сервис для работы с кафедрой
 */

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
