package com.vkkzlabs.entity;

import javax.persistence.*;

@Entity
@Table(name = "Chair")
public class Chair {
    @Id
    @Column(name="IdChair")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idChair;

    @Column(name = "NameChair")
    private String nameChair;

    @ManyToOne
    @JoinColumn(name = "IdFaculty")
    private Faculty faculty;

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public int getIdChair() {
        return idChair;
    }

    public void setIdChair(int idChair) {
        this.idChair = idChair;
    }

    public String getNameChair() {
        return nameChair;
    }

    public void setNameChair(String nameChair) {
        this.nameChair = nameChair;
    }
}
