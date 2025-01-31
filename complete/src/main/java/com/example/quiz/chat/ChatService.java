package com.example.quiz.chat;

import com.example.quiz.chat.jpa.DialogRepo;
import com.example.quiz.chat.jpa.MessageEnt;
import com.example.quiz.chat.jpa.PictureEnt;
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

@Transactional
public List<ChatMessage> allMessages(String dialog){
    var list =  dialogRepo.findByName(dialog)
            .orElseThrow()
            .getMessages()
            .stream()
            .map(MessageEnt::toChatMessage)
            .toList();

    return list;
}
@Transactional
    public List<PictureMessage> allPictures(String dialog){
        var list =  dialogRepo.findByName(dialog)
                .orElseThrow()
                .getPictures()
                .stream()
                .map(PictureMessage::from)
                .toList();

        return list;
    }

}
