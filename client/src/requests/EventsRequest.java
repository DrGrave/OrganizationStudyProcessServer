package requests;

import com.vkkzlabs.api.entity.Subject;
import com.vkkzlabs.api.entity.Timetable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EventsRequest {
    public List<Timetable> getAllEvents() {
        List<Timetable> list = new ArrayList<>();
        Timetable timetable = new Timetable();
        Date date = new Date();
        date.setHours(19);
        Date dateOfStart = new Date();
        dateOfStart.setHours(21);
        Subject subject = new Subject();
        subject.setNameSubject("POVS");
        timetable.setSubject(subject);
        timetable.setAuditory("234");
        timetable.setDate(date);
        timetable.setTimeOfEndWork(dateOfStart);
        list.add(timetable);

        date = new Date();
        date.setDate(2);
        date.setHours(12);
        dateOfStart = new Date();
        dateOfStart.setDate(2);
        dateOfStart.setHours(14);
        timetable = new Timetable();
        timetable.setSubject(subject);
        timetable.setDate(date);
        timetable.setTimeOfEndWork(dateOfStart);
        timetable.setAuditory("234");
        list.add(timetable);

        date = new Date();
        date.setDate(2);
        date.setHours(15);
        dateOfStart = new Date();
        dateOfStart.setDate(2);
        dateOfStart.setHours(16);
        timetable = new Timetable();
        timetable.setSubject(subject);
        timetable.setDate(date);
        timetable.setTimeOfEndWork(dateOfStart);
        timetable.setAuditory("234");
        list.add(timetable);

        date = new Date();
        date.setDate(2);
        date.setHours(12);
        dateOfStart = new Date();
        dateOfStart.setDate(2);
        dateOfStart.setHours(14);
        timetable = new Timetable();
        timetable.setSubject(subject);
        timetable.setDate(date);
        timetable.setTimeOfEndWork(dateOfStart);
        timetable.setAuditory("234");
        list.add(timetable);

        date = new Date();
        date.setDate(3);
        date.setHours(12);
        dateOfStart = new Date();
        dateOfStart.setDate(3);
        dateOfStart.setHours(14);
        timetable = new Timetable();
        timetable.setSubject(subject);
        timetable.setDate(date);
        timetable.setTimeOfEndWork(dateOfStart);
        timetable.setAuditory("234");
        list.add(timetable);
        return list;
    }
}
