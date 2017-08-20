package com.vkkzlabs.api.entity;

import javax.persistence.*;

/**
 * Объект группа студента
 */

@Entity
@Table(name="StudentGroup")
public class StudentGroup {
    @Id
    @Column(name="IdGroup")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int idGroup;

    /**
     * Номер группы
     */

    @Column(name = "NumberOfGroup")
    private String numberOfGroup;

    /**
     * Курс студентов
     */

    @Column(name = "Course")
    private int course;

    /**
     * Объект кафедра
     */

    @ManyToOne
    @JoinColumn(name = "IdChair")
    private Chair chair;

    /**
     * ид старосты
     */

    @Column(name = "IdUserStarosta", nullable = false)
    private int idMyUserStarosta;

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

    public int getIdMyUserStarosta() {
        return idMyUserStarosta;
    }

    public void setIdMyUserStarosta(int idMyUserStarosta) {
        this.idMyUserStarosta = idMyUserStarosta;
    }
}
