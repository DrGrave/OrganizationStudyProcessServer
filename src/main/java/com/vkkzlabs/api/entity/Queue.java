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
    @JoinColumn(name = "IdUser")
    private MyUser MyUser;

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

    public MyUser getMyUser() {
        return MyUser;
    }

    public void setMyUser(MyUser MyUser) {
        this.MyUser = MyUser;
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
                ", MyUser=" + MyUser +
                ", timeteable=" + timetable +
                ", work=" + work +
                '}';
    }
}
