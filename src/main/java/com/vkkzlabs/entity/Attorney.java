package com.vkkzlabs.entity;

import javax.persistence.*;


@Entity
@Table(name="Attorney")
public class Attorney {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAttorney;

    @ManyToOne
        @JoinColumn(name = "IdTypeOfAttorney")
    private
    TypeOfAttorney typeOfAttorney;

    @ManyToOne
        @JoinColumn(name = "IdSubject")
    private
    Subject subject;

    @ManyToOne
        @JoinColumn(name = "IdUserProfessor")
    private
    MyUser idMyUserProfessor;

    @ManyToOne
        @JoinColumn(name = "IdUserStudent")
    private
    MyUser idMyUserStudent;

    public int getIdAttorney() {
        return idAttorney;
    }

    public void setIdAttorney(int idAttorney) {
        this.idAttorney = idAttorney;
    }

    public TypeOfAttorney getTypeOfAttorney() {
        return typeOfAttorney;
    }

    public void setTypeOfAttorney(TypeOfAttorney typeOfAttorney) {
        this.typeOfAttorney = typeOfAttorney;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public MyUser getIdMyUserProfessor() {
        return idMyUserProfessor;
    }

    public void setIdMyUserProfessor(MyUser idMyUserProfessor) {
        this.idMyUserProfessor = idMyUserProfessor;
    }

    public MyUser getIdMyUserStudent() {
        return idMyUserStudent;
    }

    public void setIdMyUserStudent(MyUser idMyUserStudent) {
        this.idMyUserStudent = idMyUserStudent;
    }
}
