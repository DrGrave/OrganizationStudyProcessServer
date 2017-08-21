package com.vkkzlabs.api.dao;

import com.vkkzlabs.api.entity.Timetable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Vadim on 10.07.2017.
 */
public interface TimetableDAO extends CrudRepository<Timetable, Long>{
    Timetable getByIdTimetable(int idTimetable);
    List<Timetable> findAllByProfessor_IdUserAndSubject_IdSubject(int idProfessor, int idSubject);
}
