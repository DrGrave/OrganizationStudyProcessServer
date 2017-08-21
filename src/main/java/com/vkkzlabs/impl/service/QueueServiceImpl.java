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
    // TODO: 21.08.17  добавить провеерку на существование объекта в бд
    @Override
    public void saveQueue(Queue queue) {
        queueDAO.save(queue);
    }

    @Override
    public Queue getQueueByIdQueue(int idQueue) {
        return queueDAO.getByIdQueue(idQueue);
    }

    @Override
    public List<Queue> getAllQueueToStudent(Queue queue) {
        return queueDAO.findAllByTimetable_IdTimetable(queue.getTimetable().getIdTimetable());
    }

    @Override
    public boolean checkIfExists(Queue queue) {
        if (queueDAO.findByTimetable_IdTimetableAndWork_IdOfWorkAndAndStudent_IdUser(queue.getTimetable().getIdTimetable(), queue.getWork().getIdOfWork(), queue.getStudent().getIdUser()) == null){
            return false;
        }else return true;
    }
}
