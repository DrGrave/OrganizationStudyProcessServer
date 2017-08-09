package com.vkkzlabs.entity;

import javax.persistence.*;
import java.sql.Blob;

@Entity
@Table(name="SubjectSupportFile")
public class SubjectSupportFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSubjectSupportFile;

    @ManyToOne
    @JoinColumn(name = "IdSubject")
    private Subject subject;

    @Column(name = "Data")
    Blob blob;

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

    public Blob getBlob() {
        return blob;
    }

    public void setBlob(Blob blob) {
        this.blob = blob;
    }
}
