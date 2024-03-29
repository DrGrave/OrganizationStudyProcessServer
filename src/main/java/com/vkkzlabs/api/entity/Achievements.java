package com.vkkzlabs.api.entity;

import javax.persistence.*;
import javax.swing.*;

/**
 * Обьект ачивка
 */

@Entity
@Table(name = "Achievements")
public class Achievements {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idOfAchievement;

    /**
     * Название ачивки
     */
    @Column(name = "NameOfAchievement")
    private String nameOfAchievement;

    /**
     * Картинка ачивки
     */
    @Column(name = "ImageOfAchievement")
    private ImageIcon imageIcon;

    /**
     * Текст ачивки
     */
    @Column(name = "TextOfAchievement")
    private String textOfAchievement;

    public int getIdOfAchievement() {
        return idOfAchievement;
    }

    public void setIdOfAchievement(int idOfAchievement) {
        this.idOfAchievement = idOfAchievement;
    }

    public String getNameOfAchievement() {
        return nameOfAchievement;
    }

    public void setNameOfAchievement(String nameOfAchievement) {
        this.nameOfAchievement = nameOfAchievement;
    }

    public ImageIcon getImageIcon() {
        return imageIcon;
    }

    public void setImageIcon(ImageIcon imageIcon) {
        this.imageIcon = imageIcon;
    }

    public String getTextOfAchievement() {
        return textOfAchievement;
    }

    public void setTextOfAchievement(String textOfAchievement) {
        this.textOfAchievement = textOfAchievement;
    }
}
