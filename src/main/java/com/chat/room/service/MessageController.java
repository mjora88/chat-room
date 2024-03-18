package com.chat.room.service;

import com.chat.room.entity.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class MessageController {
    private final Logger log = LoggerFactory.getLogger(MessageController.class);
    private final MessageService messageService;
    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping
    public ResponseEntity<List<Message>> getAllMessages () {
        List<Message> messages = messageService.getAllMessages();
        log.info("No of messages fetched {}", messages.size());
        return ResponseEntity.ok(messages);
    }

    @PostMapping
    public ResponseEntity<Void> saveMessage (@RequestBody Message message) {
        messageService.saveMessage(message);
        return ResponseEntity.status(HttpStatus.CREATED).build();

        }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMessages (@PathVariable Long id) {
        if(!messageService.exists(id)) {
            log.info("The is no message available for deletion");
            return ResponseEntity.notFound().build();
        }

        messageService.deleteMessage(id);
        log.info("Message successfully deleted");
        return ResponseEntity.noContent().build();
    }
}
