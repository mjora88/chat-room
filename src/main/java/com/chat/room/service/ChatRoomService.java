package com.chat.room.service;

import com.chat.room.entity.ChatRoom;
import com.chat.room.repository.ChatRoomRepository;
import org.springframework.stereotype.Service;

@Service
public class ChatRoomService {

    private final ChatRoomRepository chatRoomRepository;

    public ChatRoomService(ChatRoomRepository chatRoomRepository) {
        this.chatRoomRepository = chatRoomRepository;
    }
    public void createChatRoom () {
        ChatRoom chatRoom = new ChatRoom();
        chatRoom.setName("The Chat Box");
        chatRoomRepository.save(chatRoom);

    }
}
