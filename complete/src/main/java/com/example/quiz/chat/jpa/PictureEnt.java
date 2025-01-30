package com.example.quiz.chat.jpa;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.util.UUID;

@Entity
public class PictureEnt {

    @Id
    @GeneratedValue
    UUID id;

    String name;

    UUID picture;

    String author;

    @ManyToOne
    Dialog dialog;

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

    public UUID getPicture() {
        return picture;
    }

    public PictureEnt setPicture(UUID picture) {
        this.picture = picture;
        return this;
    }

    public String getAuthor() {
        return author;
    }

    public PictureEnt setAuthor(String author) {
        this.author = author;
        return this;
    }
}
