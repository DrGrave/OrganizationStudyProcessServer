package com.vkkzlabs.api.dao;

import com.vkkzlabs.api.entity.TypeInClass;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Vadim on 10.07.2017.
 */
public interface TypeInClassDAO extends CrudRepository<TypeInClass, Long>{
    TypeInClass getByIdTypeInClass(int idTypeInClass);
}
