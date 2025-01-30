package com.example.quiz.chat.jpa;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity

public class Dialog {

    @Id
    @GeneratedValue
    UUID id;

    String name;

    @OneToMany(mappedBy = "dialog",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    List<MessageEnt> messages = new ArrayList<>();

    @OneToMany(mappedBy = "dialog",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    List<PictureEnt> pictures = new ArrayList<>();

    public UUID getId() {
        return id;
    }

    public Dialog setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Dialog setName(String name) {
        this.name = name;
        return this;
    }

    public List<MessageEnt> getMessages() {
        return messages;
    }

    public Dialog setMessages(List<MessageEnt> messages) {
        this.messages = messages;
        return this;
    }

    public Dialog addMessage(MessageEnt messageEnt) {
        System.out.println("Message: " + messageEnt);
        System.out.println(this);
        this.messages.add(messageEnt);
        messageEnt.setDialog(this);
        return this;
    }

    public Dialog addPicture(PictureEnt pictureEnt) {
        this.pictures.add(pictureEnt);
        pictureEnt.setDialog(this);
        return this;
    }

    @Override
    public String toString() {
        return "Dialog{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", messages=" + messages +
                ", pictures=" + pictures +
                '}';
    }
}
