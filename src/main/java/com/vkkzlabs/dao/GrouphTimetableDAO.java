package com.vkkzlabs.dao;

import com.vkkzlabs.entity.M2MGroupTimeteable;
import org.springframework.data.repository.CrudRepository;


public interface GrouphTimetableDAO extends CrudRepository<M2MGroupTimeteable, Long> {
    M2MGroupTimeteable getByIdGroupTimetable(int idTimetable);
}
