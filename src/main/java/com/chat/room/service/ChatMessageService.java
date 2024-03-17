package com.chat.room.service;

import com.chat.room.entity.ChatMessage;
import com.chat.room.repository.ChatMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatMessageService {
    public final ChatMessageRepository chatMessageRepository;
    @Autowired
    public ChatMessageService(ChatMessageRepository chatMessageRepository) {
        this.chatMessageRepository = chatMessageRepository;
    }

    public void saveMessage(ChatMessage chatMessage) {
        chatMessageRepository.save(chatMessage);
    }

    public List<ChatMessage> getAllMessages (){
        return chatMessageRepository.findAll();
    }

    public void deleteMessage (Long id){
        chatMessageRepository.deleteById(id);
    }

    public Boolean exists (Long id){
        return chatMessageRepository.existsById(id);
    }

}
