package com.chat.room.service;

import com.chat.room.entity.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

import java.util.Objects;

@Controller
public class ChatController {
    @MessageMapping("/chat.register")
    @SendTo("/topic/public")
    public Message register(@Payload Message message, SimpMessageHeaderAccessor simpMessageHeaderAccessor) {
        Objects.requireNonNull(simpMessageHeaderAccessor.getSessionAttributes()).put("username", message.getSender());
        return message;
    }
    @MessageMapping("/chat.send")
    @SendTo("/topic/public")
    public Message sendMessage (@Payload Message message, SimpMessageHeaderAccessor accessor){
        String username = (String) Objects.requireNonNull(accessor.getSessionAttributes()).get("username");
        message.setSender(username);
        return message;
    }
}
