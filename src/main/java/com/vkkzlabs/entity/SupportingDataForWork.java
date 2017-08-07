package com.vkkzlabs.entity;

import javax.persistence.*;

@Entity
@Table(name="SupportingDataForWork")
public class SupportingDataForWork {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSupportingDataForWork;

    @ManyToOne
    @JoinColumn(name = "IdWork")
    private Work work;

    @Column(name = "PathToData")
    private String pathToData;

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

    public String getPathToData() {
        return pathToData;
    }

    public void setPathToData(String pathToData) {
        this.pathToData = pathToData;
    }
}
