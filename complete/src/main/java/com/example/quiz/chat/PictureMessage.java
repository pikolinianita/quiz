package com.example.quiz.chat;

import com.example.quiz.chat.jpa.PictureEnt;

import java.util.UUID;

public class PictureMessage implements MessageInterface {
    String user;
    String picture;
    MessageType type;
    UUID pictureID;

    @Override
    public String getUser() {
        return user;
    }

    @Override
    public PictureMessage setUser(String user) {
        this.user = user;
        return this;
    }

    public String getPicture() {
        return picture;
    }

    public PictureMessage setPicture(String picture) {
        this.picture = picture;
        return this;
    }

    @Override
    public MessageType getType() {
        return type;
    }

    @Override
    public PictureMessage setType(MessageType type) {
        this.type = type;
        return this;
    }

    public UUID getPictureID() {
        return pictureID;
    }

    public PictureMessage setPictureID(UUID pictureID) {
        this.pictureID = pictureID;
        return this;
    }

    public static PictureMessage from(PictureEnt entity) {
        var result =  new PictureMessage();
        result.user = entity.getAuthor();
        result.picture = entity.getPictureData();
        result.pictureID = entity.getPictureID();
        result.type = MessageType.PICTURE;
        return result;
    }
}
