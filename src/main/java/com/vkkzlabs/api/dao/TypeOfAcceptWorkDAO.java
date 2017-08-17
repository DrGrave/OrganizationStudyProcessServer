package com.vkkzlabs.api.dao;

import com.vkkzlabs.api.entity.TypeOfAcceptWork;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Vadim on 10.07.2017.
 */
public interface TypeOfAcceptWorkDAO extends CrudRepository<TypeOfAcceptWork, Long>{
    TypeOfAcceptWork getByIdOfAccaptWork(int idOfAcceptWork);
}
