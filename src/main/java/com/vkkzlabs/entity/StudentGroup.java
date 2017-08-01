package com.vkkzlabs.entity;

import javax.persistence.*;
import java.sql.Date;


@Entity
@Table(name="StudentGroup")
public class StudentGroup {
    @Id
    @Column(name="IdGroup")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int idGroup;

    @Column(name = "NumberOfGroup")
    private String numberOfGroup;

    @Column(name = "Course")
    private int course;

    @ManyToOne
    @JoinColumn(name = "IdChair")
    private Chair chair;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdUserStarosta", nullable = false)
    private MyUser idMyUserStarosta;

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public Chair getChair() {
        return chair;
    }

    public void setChair(Chair chair) {
        this.chair = chair;
    }

    public int getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(int idGroup) {
        this.idGroup = idGroup;
    }

    public String getNumberOfGroup() {
        return numberOfGroup;
    }

    public void setNumberOfGroup(String numberOfGroup) {
        this.numberOfGroup = numberOfGroup;
    }

    public MyUser getIdMyUserStarosta() {
        return idMyUserStarosta;
    }

    public void setIdMyUserStarosta(MyUser idMyUserStarosta) {
        this.idMyUserStarosta = idMyUserStarosta;
    }

}
