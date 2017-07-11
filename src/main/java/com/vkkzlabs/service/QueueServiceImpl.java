package com.vkkzlabs.service;

import com.vkkzlabs.dao.QueueDAO;
import com.vkkzlabs.entity.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QueueServiceImpl implements QueueService {
    @Autowired
    private QueueDAO queueDAO;

    @Override
    public Queue getQueueByIdQueue(int idQueue) {
        return queueDAO.getByIdQueue(idQueue);
    }
}
