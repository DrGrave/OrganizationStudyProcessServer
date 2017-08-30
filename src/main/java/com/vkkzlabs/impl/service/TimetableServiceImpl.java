package com.vkkzlabs.impl.service;

import com.vkkzlabs.api.dao.TimetableDAO;
import com.vkkzlabs.api.entity.Timetable;
import com.vkkzlabs.api.service.TimetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public Timetable getTimetableByProfessorIdAndSubjectId(int professorId, int subjectId) {
        List<Timetable> timetables;
        Date date = new Date(System.currentTimeMillis()); // TODO сделать возможность по настройке становиться в очередть или нет.
        Timetable queueTimetable;
        timetables = timetableDAO.findAllByProfessor_IdUser(professorId);
        for (Timetable timetable : timetables){
            if (timetable.getTimeOfEndWork().getTime() >= date.getTime()){
                queueTimetable = timetable;
                return queueTimetable;
            }
        }
        return null;
    }

    @Override
    public List<Timetable> getAllTimetableToUser(int idUser) {
        return timetableDAO.findAllByProfessor_IdUser(idUser);
    }
}
