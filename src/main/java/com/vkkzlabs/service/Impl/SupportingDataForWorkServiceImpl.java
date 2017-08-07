package com.vkkzlabs.service.Impl;

import com.vkkzlabs.dao.SupportingDataForWorkDAO;
import com.vkkzlabs.entity.SupportingDataForWork;
import com.vkkzlabs.service.SupportingDataForWorkService;
import org.springframework.beans.factory.annotation.Autowired;

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
