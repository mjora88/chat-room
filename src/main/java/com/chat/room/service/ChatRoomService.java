package com.chat.room.service;

import com.chat.room.entity.ChatRoom;
import com.chat.room.repository.ChatRoomRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ChatRoomService {
    private final Logger log = LoggerFactory.getLogger(ChatRoomService.class);
    private final ChatRoomRepository chatRoomRepository;

    public ChatRoomService(ChatRoomRepository chatRoomRepository) {
        this.chatRoomRepository = chatRoomRepository;
    }
    public void createChatRoom () {
        ChatRoom chatRoom = new ChatRoom();
        chatRoom.setName("The Chat Box");
        chatRoomRepository.save(chatRoom);
        log.info("Successfully created a Chat Room {}", chatRoom.getName());

    }
}
