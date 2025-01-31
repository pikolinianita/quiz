package com.example.quiz.chat;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ChatController {

    private final ChatService chatService;

    private final SimpMessagingTemplate messagingTemplate;

    public ChatController(ChatService chatService, SimpMessagingTemplate messagingTemplate) {
        this.chatService = chatService;
        this.messagingTemplate = messagingTemplate;
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

    @MessageMapping("/history")
    //@SendTo("/topic/chat")
    public void history(String noIdeaWhy) {
        System.out.println("Chat Controller received history request " + noIdeaWhy);
        chatService.allMessages("default")
                .forEach(msg -> messagingTemplate.convertAndSend("/topic/chat", msg));
        chatService.allPictures("default")
                .forEach(msg -> messagingTemplate.convertAndSend("/topic/chat", msg));
    }

    @GetMapping("/api/v1/allMessages")
    public ResponseEntity<List<ChatMessage>> allMessages() {
        return new ResponseEntity<>(chatService.allMessages("default"), HttpStatus.OK);
    }
}
