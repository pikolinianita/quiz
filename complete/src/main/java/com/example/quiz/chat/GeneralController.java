package com.example.quiz.chat;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GeneralController {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("name", "Unnamed");
        return "roomchoice";
    }

    @PostMapping("/")
    public String roomChoice(Model model) {
        return "room";
    }

}


