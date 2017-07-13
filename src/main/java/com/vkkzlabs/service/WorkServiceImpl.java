package com.vkkzlabs.service;

import com.vkkzlabs.dao.WorkDAO;
import com.vkkzlabs.entity.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkServiceImpl implements WorkService{
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