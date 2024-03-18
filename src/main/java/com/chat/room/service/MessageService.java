package com.chat.room.service;

import com.chat.room.entity.Message;
import com.chat.room.repository.MessageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    private final Logger log = LoggerFactory.getLogger(MessageService.class);
    public final MessageRepository messageRepository;
    @Autowired
    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public Message saveMessage(Message message) {
        log.info("Attempting to save message from {}", message.getSender());
       return messageRepository.save(message);
    }

    public List<Message> getAllMessages (){
        log.info("Fetching all the messages");
        return messageRepository.findAll();
    }

    public void deleteMessage (Long id){
        log.info("Attempting to delete message by ID {}", id);
        messageRepository.deleteById(id);

    }

    public Boolean exists (Long id){
        return messageRepository.existsById(id);
    }

}
