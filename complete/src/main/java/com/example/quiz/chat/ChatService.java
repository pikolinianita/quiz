package com.example.quiz.chat;

import com.example.quiz.chat.jpa.DialogRepo;
import com.example.quiz.chat.jpa.MessageEnt;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatService {

    DialogRepo dialogRepo;

    public ChatService(DialogRepo dialogRepo) {
        this.dialogRepo = dialogRepo;
    }

    @Transactional
    public void addMessage(ChatMessage msg){
    var dialog = dialogRepo.findByName("default")
            .orElseThrow()
            .addMessage(MessageEnt.from(msg));
            dialogRepo.save(dialog);
}


public List<ChatMessage> allMessages(String dialog){
    return dialogRepo.findByName(dialog)
            .orElseThrow()
            .getMessages()
            .stream()
            .map(MessageEnt::toChatMessage)
            .toList();
}

}
