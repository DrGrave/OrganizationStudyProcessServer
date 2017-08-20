package com.vkkzlabs.api.dao;

import com.vkkzlabs.api.entity.Question;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Vadim on 10.07.2017.
 */
public interface QuestionDAO extends CrudRepository<Question, Long> {
    Question getByIdQuestion(int idQuestion);
}
