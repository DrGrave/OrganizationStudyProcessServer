package com.vkkzlabs.entity;

import javax.persistence.*;
import java.util.Comparator;

@Entity
@Table(name = "M2MStudentWork")
public class M2MStudentWork {
    @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int idM2MStudentWork;

    @ManyToOne
        @JoinColumn(name = "IdOfWork")
        private Work idOfWork;

    @ManyToOne
        @JoinColumn(name = "IdUser")
        private MyUser idUser;

    @ManyToOne
        @JoinColumn(name = "IdTypeOfAccepted")
        private TypeOfAcceptWork idOfAccaptWork;


    @ManyToOne
        @JoinColumn(name = "IdTimetable")
        private Timetable timetable;

    @Column(name = "Mark")
        private int Mark;

    public Timetable getTimetable() {
        return timetable;
    }

    public void setTimetable(Timetable timetable) {
        this.timetable = timetable;
    }

    public int getMark() {
        return Mark;
    }

    public void setMark(int mark) {
        Mark = mark;
    }

    public int getIdM2MStudentWork() {
        return idM2MStudentWork;
    }

    public void setIdM2MStudentWork(int idM2MStudentWork) {
        this.idM2MStudentWork = idM2MStudentWork;
    }

    public TypeOfAcceptWork getIdOfAccaptWork() {
        return idOfAccaptWork;
    }

    public void setIdOfAccaptWork(TypeOfAcceptWork idOfAccaptWork) {
        this.idOfAccaptWork = idOfAccaptWork;
    }

    public Work getIdOfWork() {
        return idOfWork;
    }

    public void setIdOfWork(Work idOfWork) {
        this.idOfWork = idOfWork;
    }

    public MyUser getIdUser() {
        return idUser;
    }

    public void setIdUser(MyUser idUser) {
        this.idUser = idUser;
    }

    public static final Comparator<M2MStudentWork> COMPARE_BY_DATE = new Comparator<M2MStudentWork>() {
        @Override
        public int compare(M2MStudentWork lhs, M2MStudentWork rhs) {
            return (int) (lhs.getIdOfWork().getDeadlineForWork().getTime() - rhs.getIdOfWork().getDeadlineForWork().getTime());
        }
    };

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
