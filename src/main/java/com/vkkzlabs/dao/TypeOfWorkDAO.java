package com.vkkzlabs.dao;

import com.vkkzlabs.entity.TypeOfWork;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Vadim on 10.07.2017.
 */
public interface TypeOfWorkDAO extends CrudRepository<TypeOfWork, Long>{
    TypeOfWork getByIdTypeOfWOrk(int idTypeOfWork);
}
