package com.vkkzlabs.api.dao;

import com.vkkzlabs.api.entity.Queue;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Vadim on 10.07.2017.
 */
public interface QueueDAO extends CrudRepository<Queue, Long>{
    Queue getByIdQueue(int idQueue);
    List<Queue> findAllByTimetable_IdTimetable(int idTimetable);
}
