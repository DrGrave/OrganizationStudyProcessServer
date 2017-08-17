package com.vkkzlabs.api.dao;

import com.vkkzlabs.api.entity.Attorney;
import org.springframework.data.repository.CrudRepository;


public interface AttorneyDAO extends CrudRepository<Attorney, Long> {
    Attorney getByIdAttorney(int id);
}
