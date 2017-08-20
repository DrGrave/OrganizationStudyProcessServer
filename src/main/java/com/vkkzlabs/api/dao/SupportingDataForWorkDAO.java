package com.vkkzlabs.api.dao;

import com.vkkzlabs.api.entity.SupportingDataForWork;
import org.springframework.data.repository.CrudRepository;

public interface SupportingDataForWorkDAO extends CrudRepository<SupportingDataForWork, Long>{
    SupportingDataForWork getByIdSupportingDataForWork(int id);
}
