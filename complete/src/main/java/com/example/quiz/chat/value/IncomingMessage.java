package com.example.quiz.chat.value;

public class IncomingMessage {

    String user;
    String message;

    public String getUser() {
        return user;
    }

    public IncomingMessage setUser(String user) {
        this.user = user;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public IncomingMessage setMessage(String message) {
        this.message = message;
        return this;
    }

    @Override
    public String toString() {
        return "IncomingMessage{" +
                "user='" + user + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
