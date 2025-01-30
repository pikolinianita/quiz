package com.example.quiz.pre;


import com.example.quiz.chat.jpa.Dialog;
import com.example.quiz.chat.jpa.DialogRepo;
import com.example.quiz.chat.jpa.MessageEnt;
import com.example.quiz.chat.jpa.PictureEnt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class DefaultDialog implements CommandLineRunner {

    @Autowired
    DialogRepo dialogRepo;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello World!");
            var dialog = new Dialog()
                    .setName("default")
                    .addMessage(new MessageEnt().setMessage("uno").setAuthor("Andy"))
                    .addMessage(new MessageEnt().setMessage("dos").setAuthor("Handy"))
                    .addMessage(new MessageEnt().setMessage("tres").setAuthor("Andy"))
                    .addPicture(new PictureEnt().setName("Ein").setAuthor("author").setPicture(UUID.randomUUID()))
                    .addPicture(new PictureEnt().setName("Zwei").setAuthor("author").setPicture(UUID.randomUUID()))
                    .addPicture(new PictureEnt().setName("Drei").setAuthor("author").setPicture(UUID.randomUUID()));
            dialogRepo.save(dialog);

    }
}
