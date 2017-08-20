package com.vkkzlabs.api.entity;

import javax.persistence.*;

/**
 * Объект доверенность
 */

@Entity
@Table(name="Attorney")
public class Attorney {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAttorney;

    /**
     * объект тип доверенности
     */
    @ManyToOne
        @JoinColumn(name = "IdTypeOfAttorney")
    private
    TypeOfAttorney typeOfAttorney;


    /**
     * объект предмет
     */
    @ManyToOne
        @JoinColumn(name = "IdSubject")
    private
    Subject subject;


    /**
     * объект профессор который выдал доверенность
     */

    @ManyToOne
        @JoinColumn(name = "IdUserProfessor")
    private
    MyUser idMyUserProfessor;

    /**
     * объект студент на которого выданна доверенность
     */

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
