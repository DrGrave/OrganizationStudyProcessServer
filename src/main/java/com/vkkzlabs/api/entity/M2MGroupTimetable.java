package com.vkkzlabs.api.entity;

import javax.persistence.*;


@Entity
@Table(name = "M2MGroupTimeteable")
public class M2MGroupTimetable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private
    int idGroupTimetable;

    @ManyToOne
        @JoinColumn(name = "IdGroup")
    private
    StudentGroup idGroup;

    @ManyToOne
        @JoinColumn(name = "IdTimeteable")
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
