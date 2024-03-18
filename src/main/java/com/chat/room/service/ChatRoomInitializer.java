package com.chat.room.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

public class ChatRoomInitializer {
    private final Logger log = LoggerFactory.getLogger(ChatRoomInitializer.class);
    private final ChatRoomService chatRoomService;

    public ChatRoomInitializer(ChatRoomService chatRoomService) {
        this.chatRoomService = chatRoomService;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void initializeChatRoom () {
        chatRoomService.createChatRoom();
        log.info("Chat Room initialized");
    }
}
