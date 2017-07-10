package com.vkkzlabs.dao;

import com.vkkzlabs.entity.M2MQuestionWork;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Vadim on 10.07.2017.
 */
public interface QuestionWorkDAO extends CrudRepository<M2MQuestionWork, Long>{
    M2MQuestionWork getByIdM2MQuestionWork(int idQuestionWork);
}
