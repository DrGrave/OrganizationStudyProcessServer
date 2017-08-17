package com.vkkzlabs.api.entity;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;


@Entity
@Table(name = "Timetable")
public class Timetable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTimeteable;

    @Column(name = "DateOfWork")
    private Date date;

    @Column(name = "TimeOfWork")
    private Time time;

    @Column(name = "TimeOfEndWork")
    private Time timeToEnd;

    @Column(name = "Auditory")
    private String auditory;

    @OneToOne
    @JoinColumn(name = "IdUser")
    private MyUser MyUser;

    @OneToOne
    @JoinColumn(name = "IdSubject")
    private Subject subject;

    public int getIdTimeteable() {
        return idTimeteable;
    }

    public void setIdTimeteable(int idTimeteable) {
        this.idTimeteable = idTimeteable;
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
                "idTimeteable=" + idTimeteable +
                ", date=" + date +
                ", time=" + time +
                ", timeToEnd=" + timeToEnd +
                ", MyUser=" + MyUser +
                ", subject=" + subject +
                '}';
    }
}
