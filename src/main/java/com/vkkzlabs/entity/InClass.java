package com.vkkzlabs.entity;

import javax.persistence.*;

/**
 * Created by vadim on 03.04.17.
 */
@Entity
@Table(name = "InClass")
public class InClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idInClass;

    @OneToOne
    @JoinColumn(name = "IdTimeteable")
    private Timetable timetable;

    @OneToOne
    @JoinColumn(name = "IdUser")
    private MyUser MyUser;

    @OneToOne
    @JoinColumn(name = "IdTypeInClass")
    private TypeInClass typeInClass;

    public int getIdInClass() {
        return idInClass;
    }

    public void setIdInClass(int idInClass) {
        this.idInClass = idInClass;
    }

    public Timetable getTimetable() {
        return timetable;
    }

    public void setTimetable(Timetable timeteable) {
        this.timetable = timeteable;
    }

    public MyUser getMyUser() {
        return MyUser;
    }

    public void setMyUser(MyUser MyUser) {
        this.MyUser = MyUser;
    }

    public TypeInClass getTypeInClass() {
        return typeInClass;
    }

    public void setTypeInClass(TypeInClass typeInClass) {
        this.typeInClass = typeInClass;
    }

    @Override
    public String toString() {
        return "InClass{" +
                "idInClass=" + idInClass +
                ", timeteable=" + timetable +
                ", MyUser=" + MyUser +
                ", typeInClass=" + typeInClass +
                '}';
    }
}
