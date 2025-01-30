package com.example.quiz.chat;

public class ChatMessage {

    String user;
    String message;
    MessageType type;

    public static ChatMessage from(IncomingMessage incomingMessage) {
        var result =  new ChatMessage();
        result.user = incomingMessage.getUser();
        result.message = incomingMessage.getMessage();
        result.type = MessageType.MESSAGE;
        return result;
    }

    public String getMessage() {
        return message;
    }

    public ChatMessage setMessage(String message) {
        this.message = message;
        return this;
    }

    public MessageType getType() {
        return type;
    }

    public ChatMessage setType(MessageType type) {
        this.type = type;
        return this;
    }

    public String getUser() {
        return user;
    }

    public ChatMessage setUser(String user) {
        this.user = user;
        return this;
    }
}
