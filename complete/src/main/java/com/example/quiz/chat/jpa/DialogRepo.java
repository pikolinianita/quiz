package com.example.quiz.chat.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface DialogRepo extends JpaRepository<Dialog, UUID> {

    Optional<Dialog> findByName(String name);
}
