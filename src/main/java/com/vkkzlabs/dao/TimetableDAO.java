package com.vkkzlabs.dao;

import com.vkkzlabs.entity.Timetable;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Vadim on 10.07.2017.
 */
public interface TimetableDAO extends CrudRepository<Timetable, Long>{
    Timetable getByIdTimeteable(int idTimetable);
}
