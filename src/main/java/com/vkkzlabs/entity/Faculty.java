package com.vkkzlabs.entity;

import javax.persistence.*;

@Entity
@Table(name = "Faculty")
public class Faculty {
    @Id
    @Column(name="IdFaculty")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idFaculty;

    @Column(name = "NameFaculty")
    private String nameFaculty;

    @ManyToOne
    @JoinColumn(name = "IdUniversity")
    private University university;

    public int getIdFaculty() {
        return idFaculty;
    }

    public void setIdFaculty(int idFaculty) {
        this.idFaculty = idFaculty;
    }

    public String getNameFaculty() {
        return nameFaculty;
    }

    public void setNameFaculty(String nameFaculty) {
        this.nameFaculty = nameFaculty;
    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }
}
