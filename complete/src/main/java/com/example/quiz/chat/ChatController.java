package com.example.quiz.chat;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ChatController {

    ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    //ToDo - chat stuff
    @MessageMapping("/msg")
    @SendTo("/topic/chat")
    public ChatMessage greeting(IncomingMessage incomingMessage) throws Exception {
        System.out.println("Chat Controller received message: " + incomingMessage);
        var chatMessage =  ChatMessage.from(incomingMessage);
        chatService.addMessage(chatMessage);
        return chatMessage;
    }

    @GetMapping("/api/v1/allMessages")
    public ResponseEntity<List<ChatMessage>> allMessages() {
        return new ResponseEntity<>(chatService.allMessages("default"), HttpStatus.OK);
    }
}
