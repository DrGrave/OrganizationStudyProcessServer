package com.vkkzlabs.entity;

import javax.persistence.*;

/**
 * Created by Vadim on 04.04.2017.
 */
@Entity
@Table(name = "M2M_Group_Timeteable")
public class M2MGroupTimeteable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private
    int idGroupTimeteablee;

    @ManyToOne
        @JoinColumn(name = "IdGroup")
    private
    StudentGroup idGroup;

    @ManyToOne
        @JoinColumn(name = "IdTimeteable")
    private
    Timeteable idTimeteable;

    public int getIdGroupTimeteablee() {
        return idGroupTimeteablee;
    }

    public void setIdGroupTimeteablee(int idGroupTimeteablee) {
        this.idGroupTimeteablee = idGroupTimeteablee;
    }

    public StudentGroup getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(StudentGroup idGroup) {
        this.idGroup = idGroup;
    }

    public Timeteable getIdTimeteable() {
        return idTimeteable;
    }

    public void setIdTimeteable(Timeteable idTimeteable) {
        this.idTimeteable = idTimeteable;
    }
}
