package com.example.quiz.chat.jpa;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class PictureEnt {

    @Id
    @GeneratedValue
    UUID id;

    String name;

    UUID pictureID;

    String author;

    @ManyToOne
    Dialog dialog;

    @Lob
    String pictureData;

    public Dialog getDialog() {
        return dialog;
    }

    public PictureEnt setDialog(Dialog dialog) {
        this.dialog = dialog;
        return this;
    }

    public UUID getId() {
        return id;
    }

    public PictureEnt setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public PictureEnt setName(String name) {
        this.name = name;
        return this;
    }

    public UUID getPictureID() {
        return pictureID;
    }

    public PictureEnt setPictureID(UUID pictureID) {
        this.pictureID = pictureID;
        return this;
    }

    public String getAuthor() {
        return author;
    }

    public PictureEnt setAuthor(String author) {
        this.author = author;
        return this;
    }


    public String getPictureData() {
        return pictureData;
    }

    public PictureEnt setPictureData(String pictureData) {
        this.pictureData = pictureData;
        return this;
    }
}
