package com.vkkzlabs.impl.service;

import com.vkkzlabs.api.dao.WorkDAO;
import com.vkkzlabs.api.entity.Work;
import com.vkkzlabs.api.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *  Сервис для работы с работами
 */

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

    @Override
    public List<Work> getWorksByIdUserAndIdSubject(int idProfessor, int idSubject) {
        return workDAO.findAllByProfessorId_IdUserAndSubject_IdSubject(idProfessor, idSubject);
    }

    @Override
    public void changeWork(Work work) {
        workDAO.save(work);
    }

    @Override
    public void deleteWork(Work work) {
        workDAO.delete(work);
    }
}
