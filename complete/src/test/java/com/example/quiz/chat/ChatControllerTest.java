package com.example.quiz.chat;

import com.example.quiz.chat.value.ChatMessage;
import com.example.quiz.chat.value.IncomingMessage;
import com.example.quiz.chat.value.MessageInterface;
import com.example.quiz.pre.DefaultDialog;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.messaging.simp.SimpMessagingTemplate;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Import({ChatService.class, ChatController.class, DefaultDialog.class})
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ChatControllerTest {

    @Autowired
    ChatService chatService;

    @Autowired
    ChatController chatController;

    @MockBean
    SimpMessagingTemplate messagingTemplate;

    @Test
    @Order(1)
    void processChatMessage() {
        var result = chatController.processChatMessage(new IncomingMessage().setUser("Newton").setMessage("apple"));
        assertThat(chatService.allMessages("default").size()).isEqualTo(4);
        assertThat(result).isInstanceOf(ChatMessage.class).extracting(ChatMessage::getMessage).isEqualTo("apple");
    }

    @Test
    @Order(2)
    void history() {

        chatController.history("default");
        Mockito.verify(messagingTemplate, Mockito.times(6))
                .convertAndSend(Mockito.eq("/topic/chat"), Mockito.any(MessageInterface.class));
    }

    @Test
    void allMessages() {
    }
}