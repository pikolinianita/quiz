package com.example.quiz.chat.jpa;

import com.example.quiz.chat.value.ChatMessage;
import com.example.quiz.chat.value.MessageType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.util.UUID;

@Entity
public class MessageEnt {

    @Id
    @GeneratedValue
    UUID id;

    @ManyToOne
    Dialog dialog;

    String message;

    String author;

    public Dialog getDialog() {
        return dialog;
    }

    public MessageEnt setDialog(Dialog dialog) {
        this.dialog = dialog;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public MessageEnt setMessage(String message) {
        this.message = message;
        return this;
    }

    public String getAuthor() {
        return author;
    }

    public MessageEnt setAuthor(String author) {
        this.author = author;
        return this;
    }

    public static MessageEnt from(ChatMessage message) {
        return new MessageEnt()
                .setMessage(message.getMessage())
                .setAuthor(message.getUser());
    }

    public ChatMessage toChatMessage() {
        return new ChatMessage()
                .setType(MessageType.MESSAGE)
                .setUser(author)
                .setMessage(message);
    }
}
