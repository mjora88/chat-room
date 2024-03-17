package com.chat.room.service;

import com.chat.room.entity.ChatMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class ChatMessageController {

    private final ChatMessageService chatMessageService;
    @Autowired
    public ChatMessageController(ChatMessageService chatMessageService) {
        this.chatMessageService = chatMessageService;
    }

    @GetMapping
    public ResponseEntity<List<ChatMessage>> getAllMessages () {
        List<ChatMessage> chatMessages = chatMessageService.getAllMessages();
        return ResponseEntity.ok(chatMessages);
    }

    @PostMapping
    public ResponseEntity<Void> saveMessage (@RequestBody ChatMessage chatMessage) {
        chatMessageService.saveMessage(chatMessage);
        return ResponseEntity.status(HttpStatus.CREATED).build();

        }

    @DeleteMapping
    public ResponseEntity<Void> deleteMessages (@PathVariable Long id) {
        if(!chatMessageService.exists(id)) {
            return ResponseEntity.notFound().build();
        }

        chatMessageService.deleteMessage(id);
        return ResponseEntity.noContent().build();
    }
}
