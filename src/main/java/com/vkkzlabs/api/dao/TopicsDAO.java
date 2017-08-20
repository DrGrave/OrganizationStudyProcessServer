package com.vkkzlabs.api.dao;

import com.vkkzlabs.api.entity.Topics;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Vadim on 10.07.2017.
 */
public interface TopicsDAO extends CrudRepository<Topics, Long>{
    Topics getByIdTopic(int idTopic);
}
