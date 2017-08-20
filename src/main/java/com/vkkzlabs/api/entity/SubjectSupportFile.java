package com.vkkzlabs.api.entity;

import javax.persistence.*;

/**
 * Объект для хранения файла предмета
 */

@Entity
@Table(name="SubjectSupportFile")
public class SubjectSupportFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSubjectSupportFile;

    /**
     * Объект предмет
     */

    @ManyToOne
    @JoinColumn(name = "IdSubject")
    private Subject subject;

    /**
     * Название файла
     */

    @Column(name = "NameOfFile")
    private String nameOfFile;

    /**
     * Путь к файлуу
     */

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
