package com.vkkzlabs.impl.service;

import com.vkkzlabs.api.dao.QueueDAO;
import com.vkkzlabs.api.entity.Queue;
import com.vkkzlabs.api.service.QueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
