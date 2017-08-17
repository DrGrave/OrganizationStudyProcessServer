package com.vkkzlabs.api.entity;

import javax.persistence.*;


@Entity
@Table(name = "M2MProfessorSubject")
public class M2MProfessorSubject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idM2MProfessorSubject;

    @ManyToOne
    @JoinColumn(name = "IdUser")
    private
    MyUser idUser;

    @ManyToOne
    @JoinColumn(name = "IdSubject")
    private
    Subject idSubject;

    public int getIdM2MProfessorSubject() {
        return idM2MProfessorSubject;
    }

    public void setIdM2MProfessorSubject(int idM2MProfessorSubject) {
        this.idM2MProfessorSubject = idM2MProfessorSubject;
    }

    public MyUser getIdUser() {
        return idUser;
    }

    public void setIdUser(MyUser idUser) {
        this.idUser = idUser;
    }

    public Subject getIdSubject() {
        return idSubject;
    }

    public void setIdSubject(Subject idSubject) {
        this.idSubject = idSubject;
    }
}
