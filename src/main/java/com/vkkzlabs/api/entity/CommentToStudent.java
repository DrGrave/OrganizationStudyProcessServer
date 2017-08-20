package com.vkkzlabs.api.entity;

import javax.persistence.*;

/**
 * Объект комментарий на студента оставленный преподавателем
 */

@Entity
@Table(name = "CommentToStudent")
public class CommentToStudent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCommentOfStudent;

    /**
     * текст комментария на студента
     */

    @Column(name = "TextOfComment")
    private String textOfComment;

    /**
     * Объект профессор который написал комментарий
     */

    @OneToOne
    @JoinColumn(name = "IdUserProfessor")
    private MyUser professor;

    /**
     * Объект студент на которого написан комментарий
     */

    @OneToOne
    @JoinColumn(name = "IdUserStudent")
    private MyUser student;

    public int getIdCommentOfStudent() {
        return idCommentOfStudent;
    }

    public void setIdCommentOfStudent(int idCommentOfStudent) {
        this.idCommentOfStudent = idCommentOfStudent;
    }

    public String getTextOfComment() {
        return textOfComment;
    }

    public void setTextOfComment(String textOfComment) {
        this.textOfComment = textOfComment;
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

    @Override
    public String toString() {
        return "CommentToStudent{" +
                "idCommentOfStudent=" + idCommentOfStudent +
                ", textOfComment='" + textOfComment + '\'' +
                ", professor=" + professor +
                ", student=" + student +
                '}';
    }
}
