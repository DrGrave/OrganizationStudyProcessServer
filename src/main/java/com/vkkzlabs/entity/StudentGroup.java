package com.vkkzlabs.entity;

import javax.persistence.*;

/**
 * Created by vadim on 03.04.17.
 */
@Entity
@Table(name="StudentGroup")
public class StudentGroup {
    @Id
    @Column(name="IdGroup")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int idGroup;

    @Column(name = "NumberOfGroup")
    private String numberOfGroup;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdUserStarosta", nullable = false)
    private MyUser idMyUserStarosta;

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
