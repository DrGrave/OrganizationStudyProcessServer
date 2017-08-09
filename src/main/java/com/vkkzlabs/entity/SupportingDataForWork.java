package com.vkkzlabs.entity;

import javax.persistence.*;
import java.sql.Blob;

@Entity
@Table(name="SupportingDataForWork")
public class SupportingDataForWork {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSupportingDataForWork;

    @ManyToOne
    @JoinColumn(name = "IdWork")
    private Work work;

    @Column(name = "Data")
    private Blob data;

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

    public Blob getData() {
        return data;
    }

    public void setData(Blob data) {
        this.data = data;
    }

    public String getNameOfFile() {
        return nameOfFile;
    }

    public void setNameOfFile(String nameOfFile) {
        this.nameOfFile = nameOfFile;
    }
}
