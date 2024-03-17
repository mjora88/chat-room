package com.chat.room.service;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

public class ChatRoomInitializer {
    private final ChatRoomService chatRoomService;

    public ChatRoomInitializer(ChatRoomService chatRoomService) {
        this.chatRoomService = chatRoomService;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void initializeChatRoom () {
        chatRoomService.createChatRoom();
    }
}
