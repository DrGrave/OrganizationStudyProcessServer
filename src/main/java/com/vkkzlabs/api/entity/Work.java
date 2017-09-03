package com.vkkzlabs.api.entity;

import javax.persistence.*;

/**
 * Объект работа
 */

@Entity
@Table(name = "Work")
public class Work {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idOfWork;

    /**
     * Номер работы
     */

    @Column(name = "NumberOfWork")
    private String numberOfWOrk;

    /**
     * Название работы
     */

    @Column(name = "NameOfWork")
    private String nameOfWork;

    /**
     * Текст работы
     */

    @Column(name = "TextOfWork")
    private String textOfWork;

    /**
     * Объект типа работы
     */

    @ManyToOne
    @JoinColumn(name = "IdTypeOfWork")
    private TypeOfWork typeOfWork;

    /**
     * Объект предмета по работе
     */

    @ManyToOne
    @JoinColumn(name = "IdSubject")
    private Subject subject;

    /**
     * Объект пользователя создавшего работу
     */

    @ManyToOne
    @JoinColumn(name = "IdProfessor")
    private MyUser professorId;



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

    public MyUser getProfessorId() {
        return professorId;
    }

    public void setProfessorId(MyUser professorId) {
        this.professorId = professorId;
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
                ", MyUser=" + professorId +
                '}';
    }
}
