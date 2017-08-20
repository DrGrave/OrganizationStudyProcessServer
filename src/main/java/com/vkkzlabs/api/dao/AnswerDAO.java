package com.vkkzlabs.api.dao;

import com.vkkzlabs.api.entity.Answer;
import org.springframework.data.repository.CrudRepository;


public interface AnswerDAO extends CrudRepository<Answer, Long> {

     @Override
     <S extends Answer> S save(S s);


     Answer getByIdAnswer(int idAnswer);
}
