package com.vkkzlabs.service;

import com.vkkzlabs.dao.TimetableDAO;
import com.vkkzlabs.entity.Timetable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TimetableServiceImpl implements TimetableService{
    @Autowired
    private TimetableDAO timetableDAO;

    @Override
    public Timetable getTimetableByIdTimetable(int idTimetable) {
        return timetableDAO.getByIdTimeteable(idTimetable);
    }
}
