package com.vkkzlabs.impl.service;

import com.vkkzlabs.api.dao.SupportingDataForWorkDAO;
import com.vkkzlabs.api.entity.SupportingDataForWork;
import com.vkkzlabs.api.service.SupportingDataForWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *  Сервис для работы с файлами для работ
 */

@Service
public class SupportingDataForWorkServiceImpl implements SupportingDataForWorkService {
    @Autowired
    private SupportingDataForWorkDAO supportingDataForWorkDAO;

    @Override
    public void saveSupportingDataForWork(SupportingDataForWork supportingDataForWork) {
        supportingDataForWorkDAO.save(supportingDataForWork);
    }

    @Override
    public SupportingDataForWork getSupportingDataForWorkById(int id) {
        return supportingDataForWorkDAO.getByIdSupportingDataForWork(id);
    }
}
