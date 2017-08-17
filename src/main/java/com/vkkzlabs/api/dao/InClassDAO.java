package com.vkkzlabs.api.dao;

import com.vkkzlabs.api.entity.InClass;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by vadim on 19.06.17.
 */
public interface InClassDAO extends CrudRepository<InClass, Long> {
    InClass findByIdInClass(int id);

    InClass getByIdInClass(int idInClass);
}
