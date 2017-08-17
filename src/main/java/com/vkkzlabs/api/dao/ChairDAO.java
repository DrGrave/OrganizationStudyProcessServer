package com.vkkzlabs.api.dao;

import com.vkkzlabs.api.entity.Chair;
import org.springframework.data.repository.CrudRepository;

public interface ChairDAO extends CrudRepository<Chair, Long>{
    Chair getByIdChair(int idChair);
}
