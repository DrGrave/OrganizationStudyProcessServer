package com.vkkzlabs.impl.service;

import com.vkkzlabs.api.dao.QueueDAO;
import com.vkkzlabs.api.entity.Queue;
import com.vkkzlabs.api.service.QueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *  Сервис для работы с очередью
 */

@Service
public class QueueServiceImpl implements QueueService {
    @Autowired
    private QueueDAO queueDAO;

    @Override
    public void saveQueue(Queue queue) {
        queueDAO.save(queue);
    }

    @Override
    public Queue getQueueByIdQueue(int idQueue) {
        return queueDAO.getByIdQueue(idQueue);
    }

    @Override
    public List<Queue> getAllQueueToStudent(int idTimetable) {
        return queueDAO.findAllByTimetable_IdTimetable(idTimetable);
    }

    @Override
    public boolean checkIfExists(Queue queue) {
        if (queueDAO.findByTimetable_IdTimetableAndWork_IdOfWorkAndAndStudent_IdUser(queue.getTimetable().getIdTimetable(), queue.getWork().getIdOfWork(), queue.getStudent().getIdUser()) == null){
            return false;
        }else return true;
    }

    @Override
    public List<Queue> getQueueToSubject(int idTimetable, int idStudent) {
        return queueDAO.findAllByTimetable_IdTimetableAndStudent_IdUser(idTimetable, idStudent);
    }
}
