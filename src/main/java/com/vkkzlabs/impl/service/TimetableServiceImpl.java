package com.vkkzlabs.impl.service;

import com.vkkzlabs.api.dao.TimetableDAO;
import com.vkkzlabs.api.entity.Timetable;
import com.vkkzlabs.api.service.TimetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *  Сервис для работы с расписаниями
 */

@Service
public class TimetableServiceImpl implements TimetableService{
    @Autowired
    private TimetableDAO timetableDAO;

    @Override
    public void saveTimetable(Timetable timetable) {
        timetableDAO.save(timetable);
    }

    @Override
    public Timetable getTimetableByIdTimetable(int idTimetable) {
        return timetableDAO.getByIdTimetable(idTimetable);
    }
}
