package com.example.quiz.chat;

public class IncomingMessage {

    String user;
    String message;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "IncomingMessage{" +
                "user='" + user + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
