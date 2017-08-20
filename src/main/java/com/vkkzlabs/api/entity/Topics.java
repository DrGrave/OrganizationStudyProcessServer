package com.vkkzlabs.api.entity;

import javax.persistence.*;

/**
 * Объект тема вопроса
 */

@Entity
@Table(name="Topics")
public class Topics {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private
    int idTopic;

    /**
     * Объект предмет
     */

    @ManyToOne
    @JoinColumn(name = "IdSubject")
    private Subject subject;

    /**
     * Название темы
     */

    @Column(name = "Topic")
    private String topic;

    public int getIdTopic() {
        return idTopic;
    }

    public void setIdTopic(int idTopic) {
        this.idTopic = idTopic;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
}
