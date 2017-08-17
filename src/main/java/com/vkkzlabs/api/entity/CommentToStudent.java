package com.vkkzlabs.api.entity;

import javax.persistence.*;


@Entity
@Table(name = "CommentToStudent")
public class CommentToStudent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCommentOfStudent;

    @Column(name = "TextOfComment")
    private String textOfComment;

    @OneToOne
    @JoinColumn(name = "IdUserProfessor")
    private MyUser professor;

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
