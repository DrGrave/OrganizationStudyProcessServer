package com.vkkzlabs.dao;

import com.vkkzlabs.entity.Chair;
import org.springframework.data.repository.CrudRepository;

public interface ChairDAO extends CrudRepository<Chair, Long>{
    Chair getByIdChair(int idChair);
}
