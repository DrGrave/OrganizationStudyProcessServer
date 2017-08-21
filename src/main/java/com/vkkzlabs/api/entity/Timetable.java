package com.vkkzlabs.api.entity;

import javax.persistence.*;
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

    @Column(name = "TimeOfEndWork")
    private Date timeOfEndWork;

    /**
     * Время окончания работы
     */

    @Column(name = "Auditory")
    private String auditory;

    /**
     * Объект профессор который ведёт пару
     */

    @ManyToOne
        @JoinColumn(name = "IdProfessor")
    private MyUser professor;

    /**
     * Объект предмет по которому проходит пара
     */

    @ManyToOne
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

    public Date getTimeOfEndWork() {
        return timeOfEndWork;
    }

    public void setTimeOfEndWork(Date timeOfEndWork) {
        this.timeOfEndWork = timeOfEndWork;
    }

    public MyUser getProfessor() {
        return professor;
    }

    public void setProfessor(MyUser professor) {
        this.professor = professor;
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


}
