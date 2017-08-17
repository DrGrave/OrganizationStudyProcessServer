package com.vkkzlabs.api.dao;

import com.vkkzlabs.api.entity.Work;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Vadim on 10.07.2017.
 */
public interface WorkDAO extends CrudRepository<Work, Long>{
    Work getByIdOfWork(int idOfWork);
}
