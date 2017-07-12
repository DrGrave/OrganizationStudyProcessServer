package com.vkkzlabs.dao;

import com.vkkzlabs.entity.Answer;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Vadim on 10.07.2017.
 */
public interface AnswerDAO extends CrudRepository<Answer, Long> {

     @Override
     <S extends Answer> S save(S s);


     Answer getByIdAnswer(int idAnswer);
}
