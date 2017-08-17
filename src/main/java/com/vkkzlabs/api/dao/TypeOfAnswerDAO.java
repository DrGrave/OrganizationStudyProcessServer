package com.vkkzlabs.api.dao;

import com.vkkzlabs.api.entity.TypeOfAnswer;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Vadim on 10.07.2017.
 */
public interface TypeOfAnswerDAO extends CrudRepository<TypeOfAnswer, Long>{
    TypeOfAnswer getByIdTypeOfAnswer(int idTypeOfAnswer);
}
