package com.vkkzlabs.api.service;

import com.vkkzlabs.api.entity.Queue;

/**
 * Created by vadim on 11.07.17.
 */
public interface QueueService {
    void saveQueue(Queue queue);
    Queue getQueueByIdQueue(int idQueue);
}
