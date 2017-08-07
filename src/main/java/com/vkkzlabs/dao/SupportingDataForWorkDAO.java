package com.vkkzlabs.dao;

import com.vkkzlabs.entity.SupportingDataForWork;
import org.springframework.data.repository.CrudRepository;

public interface SupportingDataForWorkDAO extends CrudRepository<SupportingDataForWork, Long>{
    SupportingDataForWork getByIdSupportingDataForWork(int id);
}
