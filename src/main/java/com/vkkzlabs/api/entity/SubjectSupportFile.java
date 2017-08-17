package com.vkkzlabs.api.entity;

import javax.persistence.*;


@Entity
@Table(name="SubjectSupportFile")
public class SubjectSupportFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSubjectSupportFile;

    @ManyToOne
    @JoinColumn(name = "IdSubject")
    private Subject subject;

    @Column(name = "NameOfFile")
    private String nameOfFile;

    @Column(name = "PathToFile", length = 65536)
    private String path;

    public int getIdSubjectSupportFile() {
        return idSubjectSupportFile;
    }

    public void setIdSubjectSupportFile(int idSubjectSupportFile) {
        this.idSubjectSupportFile = idSubjectSupportFile;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getNameOfFile() {
        return nameOfFile;
    }

    public void setNameOfFile(String nameOfFile) {
        this.nameOfFile = nameOfFile;
    }
}
