package com.vkkzlabs.entity;

import javax.persistence.*;

/**
 * Created by vadim on 03.04.17.
 */
@Entity
@Table(name = "Queue")
public class Queue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idQueue;

    @ManyToOne
    @JoinColumn(name = "IdUSer")
    private MyUser MyUser;

    @ManyToOne
    @JoinColumn(name = "IdTimeteable")
    private Timetable timetable;

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
