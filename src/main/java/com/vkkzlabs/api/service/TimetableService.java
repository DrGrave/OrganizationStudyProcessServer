package com.vkkzlabs.api.service;


import com.vkkzlabs.api.entity.Timetable;

import java.util.List;

public interface TimetableService {
    void saveTimetable(Timetable timetable);
    Timetable getTimetableByIdTimetable(int idTimetable);

    Timetable getTimetableByProfessorIdAndSubjectId(int professorId, int subjectId);

    List<Timetable> getAllTimetableToUser(int idUser);
}
