package com.vkkzlabs.entity;

import javax.persistence.*;


@Entity
@Table(name = "Work")
public class Work {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idOfWork;

    @Column(name = "NumberOfWork")
    private String numberOfWOrk;

    @Column(name = "NameOfWork")
    private String nameOfWork;

    @Column(name = "TextOfWork")
    private String textOfWork;

    @ManyToOne
    @JoinColumn(name = "IdTypeOfWork")
    private TypeOfWork typeOfWork;

    @ManyToOne
    @JoinColumn(name = "IdSubject")
    private Subject subject;

    @ManyToOne
    @JoinColumn(name = "IdUser")
    private MyUser MyUser;

    public int getIdOfWork() {
        return idOfWork;
    }

    public void setIdOfWork(int idOfWork) {
        this.idOfWork = idOfWork;
    }

    public String getNumberOfWOrk() {
        return numberOfWOrk;
    }

    public void setNumberOfWOrk(String numberOfWOrk) {
        this.numberOfWOrk = numberOfWOrk;
    }

    public String getNameOfWork() {
        return nameOfWork;
    }

    public void setNameOfWork(String nameOfWork) {
        this.nameOfWork = nameOfWork;
    }

    public String getTextOfWork() {
        return textOfWork;
    }

    public void setTextOfWork(String textOfWork) {
        this.textOfWork = textOfWork;
    }

    public TypeOfWork getTypeOfWork() {
        return typeOfWork;
    }

    public void setTypeOfWork(TypeOfWork typeOfWork) {
        this.typeOfWork = typeOfWork;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public MyUser getMyUser() {
        return MyUser;
    }

    public void setMyUser(MyUser MyUser) {
        this.MyUser = MyUser;
    }

    @Override
    public String toString() {
        return "Work{" +
                "idOfWork=" + idOfWork +
                ", numberOfWOrk='" + numberOfWOrk + '\'' +
                ", nameOfWork='" + nameOfWork + '\'' +
                ", textOfWork='" + textOfWork + '\'' +
                ", typeOfWork=" + typeOfWork +
                ", subject=" + subject +
                ", MyUser=" + MyUser +
                '}';
    }
}
