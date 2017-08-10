package com.vkkzlabs.entity;

import javax.persistence.*;
import java.io.File;

@Entity
@Table(name="SupportingDataForWork")
public class SupportingDataForWork {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSupportingDataForWork;

    @ManyToOne
    @JoinColumn(name = "IdWork")
    private Work work;

    @Column(name = "PathToFile", length = 65536)
    private String pathToFile;

    @Column(name = "NameOfFile")
    private String nameOfFile;

    public int getIdSupportingDataForWork() {
        return idSupportingDataForWork;
    }

    public void setIdSupportingDataForWork(int idSupportingDataForWork) {
        this.idSupportingDataForWork = idSupportingDataForWork;
    }

    public Work getWork() {
        return work;
    }

    public void setWork(Work work) {
        this.work = work;
    }

    public String getPathToFile() {
        return pathToFile;
    }

    public void setPathToFile(String pathToFile) {
        this.pathToFile = pathToFile;
    }

    public String getNameOfFile() {
        return nameOfFile;
    }

    public void setNameOfFile(String nameOfFile) {
        this.nameOfFile = nameOfFile;
    }
}
