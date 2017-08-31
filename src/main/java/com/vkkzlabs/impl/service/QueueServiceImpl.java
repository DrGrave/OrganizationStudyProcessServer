package com.vkkzlabs.impl.service;

import com.vkkzlabs.api.dao.QueueDAO;
import com.vkkzlabs.api.entity.Queue;
import com.vkkzlabs.api.entity.Timetable;
import com.vkkzlabs.api.service.QueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
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
        if (queueDAO.findByTimetable_IdTimetableAndWork_IdOfWorkAndStudent_IdUser(queue.getTimetable().getIdTimetable(), queue.getWork().getIdOfWork(), queue.getStudent().getIdUser()) == null){
            return false;
        }else return true;
    }

    @Override
    public List<Queue> getQueueToSubject(int idTimetable, int idStudent) {
        return queueDAO.findAllByTimetable_IdTimetableAndStudent_IdUser(idTimetable, idStudent);
    }

    @Override
    public List<Queue> tryToGetQueue(int idUser) {
        List<Queue> queue = queueDAO.findAllByStudent_IdUser(idUser);
        Date date = new Date(System.currentTimeMillis());
        for (Queue queu : queue){
            if (queue != null && queu.getTimetable().getTimeOfEndWork().getTime() >= date.getTime()){
                return queueDAO.findAllByTimetable_IdTimetable(queu.getTimetable().getIdTimetable());
            }
        }
        return null;
    }

    @Override
    public void deleteByIdTimetableIdWorkIdStudent(int timetableId, int idOfWork, int studentId) {
        Queue queue = queueDAO.findByTimetable_IdTimetableAndWork_IdOfWorkAndStudent_IdUser(timetableId,idOfWork,studentId);
        queueDAO.delete(queue);
    }
}
