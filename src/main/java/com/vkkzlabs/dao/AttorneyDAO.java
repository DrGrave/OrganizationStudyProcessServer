package com.vkkzlabs.dao;

import com.vkkzlabs.entity.Attorney;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by vadim on 19.06.17.
 */
public interface AttorneyDAO extends CrudRepository<Attorney, Long> {
    Attorney getByIdAttorney(int id);
}
