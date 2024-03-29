package com.vkkzlabs.api.dao;

import com.vkkzlabs.api.entity.TypeOfWork;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Vadim on 10.07.2017.
 */
public interface TypeOfWorkDAO extends CrudRepository<TypeOfWork, Long>{
    TypeOfWork getByIdTypeOfWOrk(int idTypeOfWork);
    List<TypeOfWork> findAll();
}
