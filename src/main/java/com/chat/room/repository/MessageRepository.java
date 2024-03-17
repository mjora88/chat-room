package com.chat.room.repository;

import com.chat.room.entity.Message;
import jakarta.annotation.Nullable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
    void deleteById(@Nullable Long id);

}
