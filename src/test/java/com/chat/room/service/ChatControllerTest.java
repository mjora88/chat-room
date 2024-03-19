package com.chat.room.service;

import com.chat.room.entity.Message;
import org.junit.jupiter.api.Test;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ChatControllerTest {

    private final ChatController chatController = new ChatController();

        @Test
        void sendMessage_UserAuthenticated_SetsSender () {
            Message message = new Message();
            SimpMessageHeaderAccessor accessor = mock((SimpMessageHeaderAccessor.class) );
            when(accessor.getSessionAttributes()).thenReturn(Map.of("username", "testUser"));

            Message result = chatController.sendMessage(message, accessor);
            assertEquals("testUser", result.getSender(),"Sender should be set to authenticated username");

        }

}
