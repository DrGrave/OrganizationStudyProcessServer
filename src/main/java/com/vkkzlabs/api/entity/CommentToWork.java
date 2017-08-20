package com.vkkzlabs.api.entity;

import javax.persistence.*;
import java.sql.Date;

/**
 * Объект комментарий на работу
 */

@Entity
@Table(name = "CommentToWork")
public class CommentToWork {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCommentToWork;

    /**
     * Текст комментария
     */

    @Column(name = "TextOfCommentWork")
    private String textOfCommentWork;

    /**
     * Дата комментария
     */

    @Column(name = "DateOfComment")
    private Date date;

    /**
     * Объект профессора который написал коментарий на работу
     */

    @OneToOne
    @JoinColumn(name = "IdUserProfessor")
    private MyUser professor;

    /**
     * Объект студента на работу которого написан комментарий
     */

    @OneToOne
    @JoinColumn(name = "IdUserStudent")
    private MyUser student;

    /**
     * Объект работы на которую сделан комментарий
     */

    @OneToOne
    @JoinColumn(name = "IdOfWork")
    private Work work;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getIdCommentToWork() {
        return idCommentToWork;
    }

    public void setIdCommentToWork(int idCommentToWork) {
        this.idCommentToWork = idCommentToWork;
    }

    public String getTextOfCommentWork() {
        return textOfCommentWork;
    }

    public void setTextOfCommentWork(String textOfCommentWork) {
        this.textOfCommentWork = textOfCommentWork;
    }

    public MyUser getProfessor() {
        return professor;
    }

    public void setProfessor(MyUser professor) {
        this.professor = professor;
    }

    public MyUser getStudent() {
        return student;
    }

    public void setStudent(MyUser student) {
        this.student = student;
    }

    public Work getWork() {
        return work;
    }

    public void setWork(Work work) {
        this.work = work;
    }

    @Override
    public String toString() {
        return "CommentToWork{" +
                "idCommentToWork=" + idCommentToWork +
                ", textOfCommentWork='" + textOfCommentWork + '\'' +
                ", professor=" + professor +
                ", student=" + student +
                ", work=" + work +
                '}';
    }
}
