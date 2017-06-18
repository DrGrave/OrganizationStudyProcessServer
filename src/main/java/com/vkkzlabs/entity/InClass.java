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
    private Timeteable timeteable;

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

    public Timeteable getTimeteable() {
        return timeteable;
    }

    public void setTimeteable(Timeteable timeteable) {
        this.timeteable = timeteable;
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
                ", timeteable=" + timeteable +
                ", MyUser=" + MyUser +
                ", typeInClass=" + typeInClass +
                '}';
    }
}
