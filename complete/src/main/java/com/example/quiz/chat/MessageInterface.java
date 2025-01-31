package com.example.quiz.chat;

public interface MessageInterface {
    MessageType getType();

    MessageInterface setType(MessageType type);

    String getUser();

    MessageInterface setUser(String user);
}
