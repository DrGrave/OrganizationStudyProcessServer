package com.vkkzlabs.dao;

import com.vkkzlabs.entity.Queue;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Vadim on 10.07.2017.
 */
public interface QueueDAO extends CrudRepository<Queue, Long>{
    Queue getByIdQueue(int idQueue);
}
