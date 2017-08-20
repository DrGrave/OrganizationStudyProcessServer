package com.vkkzlabs.api.service;


import com.vkkzlabs.api.entity.Timetable;

public interface TimetableService {
    void saveTimetable(Timetable timetable);
    Timetable getTimetableByIdTimetable(int idTimetable);
}
