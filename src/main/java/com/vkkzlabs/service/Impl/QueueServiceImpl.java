package com.vkkzlabs.service.Impl;

import com.vkkzlabs.dao.QueueDAO;
import com.vkkzlabs.entity.Queue;
import com.vkkzlabs.service.QueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
