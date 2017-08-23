package com.vkkzlabs.api.entity;

import javax.persistence.*;

/**
 * Объект элемент очереди
 */

@Entity
@Table(name = "Queue")
public class Queue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idQueue;

    /**
     * Объект студент
     */

    @ManyToOne
    @JoinColumn(name = "IdStudent")
    private MyUser student;

    /**
     * Объект расписание
     */

    @ManyToOne
    @JoinColumn(name = "IdTimetable")
    private Timetable timetable;

    /**
     * Объект работа
     */

    @ManyToOne
    @JoinColumn(name = "IdOfWork")
    private Work work;

    public int getIdQueue() {
        return idQueue;
    }

    public void setIdQueue(int idQueue) {
        this.idQueue = idQueue;
    }

    public MyUser getStudent() {
        return student;
    }

    public void setStudent(MyUser student) {
        this.student = student;
    }

    public Timetable getTimetable() {
        return timetable;
    }

    public void setTimetable(Timetable timeteable) {
        this.timetable = timeteable;
    }

    public Work getWork() {
        return work;
    }

    public void setWork(Work work) {
        this.work = work;
    }

    @Override
    public String toString() {
        return "Queue{" +
                "idQueue=" + idQueue +
                ", MyUser=" + student +
                ", timeteable=" + timetable +
                ", work=" + work +
                '}';
    }
}
