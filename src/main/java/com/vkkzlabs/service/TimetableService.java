package com.vkkzlabs.service;


import com.vkkzlabs.entity.Timetable;

public interface TimetableService {
    void saveTimetable(Timetable timetable);
    Timetable getTimetableByIdTimetable(int idTimetable);
}
