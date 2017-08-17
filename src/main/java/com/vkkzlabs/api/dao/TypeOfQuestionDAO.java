package com.vkkzlabs.api.dao;

import com.vkkzlabs.api.entity.TypeOfQuestion;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Vadim on 10.07.2017.
 */
public interface TypeOfQuestionDAO extends CrudRepository<TypeOfQuestion, Long>{
    TypeOfQuestion getByIdTypeOfQuestion (int idTypeOfQuestion);
}
