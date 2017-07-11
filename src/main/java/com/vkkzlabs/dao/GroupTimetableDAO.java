package com.vkkzlabs.dao;

import com.vkkzlabs.entity.M2MGroupTimetable;
import org.springframework.data.repository.CrudRepository;


public interface GroupTimetableDAO extends CrudRepository<M2MGroupTimetable, Long> {
    M2MGroupTimetable getByIdGroupTimetable(int idTimetable);
}
