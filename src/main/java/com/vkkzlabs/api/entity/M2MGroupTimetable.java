package com.vkkzlabs.api.entity;

import javax.persistence.*;

/**
 * Объект для связи студенческих групп и расписания
 */

@Entity
@Table(name = "M2MGroupTimetable")
public class M2MGroupTimetable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private
    int idGroupTimetable;

    /**
     * Объект студенческой группы
     */

    @ManyToOne
        @JoinColumn(name = "IdGroup")
    private
    StudentGroup idGroup;

    /**
     * Объект расписания
     */

    @ManyToOne
        @JoinColumn(name = "IdTimetable")
    private
    Timetable idTimetable;

    public int getIdGroupTimetable() {
        return idGroupTimetable;
    }

    public void setIdGroupTimetable(int idGroupTimeteablee) {
        this.idGroupTimetable = idGroupTimeteablee;
    }

    public StudentGroup getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(StudentGroup idGroup) {
        this.idGroup = idGroup;
    }

    public Timetable getIdTimetable() {
        return idTimetable;
    }

    public void setIdTimetable(Timetable idTimeteable) {
        this.idTimetable = idTimeteable;
    }
}
