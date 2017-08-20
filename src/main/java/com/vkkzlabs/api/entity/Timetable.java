package com.vkkzlabs.api.entity;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

/**
 * Объект расписание
 */

@Entity
@Table(name = "Timetable")
public class Timetable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTimetable;

    /**
     * Дата работы
     */

    @Column(name = "DateOfWork")
    private Date date;

    /**
     * Время начала работы
     */

    @Column(name = "TimeOfWork")
    private Time time;

    /**
     * Время окончания работы
     */

    @Column(name = "TimeOfEndWork")
    private Time timeToEnd;

    /**
     * Аудитория пары
     */

    @Column(name = "Auditory")
    private String auditory;

    /**
     * Объект профессор который ведёт пару
     */

    @OneToOne
    @JoinColumn(name = "IdUser")
    private MyUser MyUser;

    /**
     * Объект предмет по которому проходит пара
     */

    @OneToOne
    @JoinColumn(name = "IdSubject")
    private Subject subject;

    public int getIdTimetable() {
        return idTimetable;
    }

    public void setIdTimetable(int idTimetable) {
        this.idTimetable = idTimetable;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Time getTimeToEnd() {
        return timeToEnd;
    }

    public void setTimeToEnd(Time timeToEnd) {
        this.timeToEnd = timeToEnd;
    }

    public MyUser getMyUser() {
        return MyUser;
    }

    public void setMyUser(MyUser MyUser) {
        this.MyUser = MyUser;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public String getAuditory() {
        return auditory;
    }

    public void setAuditory(String auditory) {
        this.auditory = auditory;
    }

    @Override
    public String toString() {
        return "Timeteable{" +
                "idTimeteable=" + idTimetable +
                ", date=" + date +
                ", time=" + time +
                ", timeToEnd=" + timeToEnd +
                ", MyUser=" + MyUser +
                ", subject=" + subject +
                '}';
    }
}
