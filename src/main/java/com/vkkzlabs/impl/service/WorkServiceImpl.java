package com.vkkzlabs.impl.service;

import com.vkkzlabs.api.dao.WorkDAO;
import com.vkkzlabs.api.entity.Work;
import com.vkkzlabs.api.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkServiceImpl implements WorkService {
    @Autowired
    private WorkDAO workDAO;

    @Override
    public void saveWork(Work work) {
        workDAO.save(work);
    }

    @Override
    public Work getWorkByIdWork(int idWork) {
        return workDAO.getByIdOfWork(idWork);
    }
}
