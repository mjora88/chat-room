package com.chat.room.repository;

import com.chat.room.entity.ChatMessage;
import jakarta.annotation.Nullable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatMessageRepository extends JpaRepository<ChatMessage, Long> {
    public void deleteById(@Nullable Long id);

}
