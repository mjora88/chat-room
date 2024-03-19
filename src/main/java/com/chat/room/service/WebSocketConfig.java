package com.chat.room.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    private final Logger log = LoggerFactory.getLogger(ChatRoomInitializer.class);
    @Override
    public void registerStompEndpoints (StompEndpointRegistry registry) {
        registry.addEndpoint("/websocket").withSockJS();
        log.info("STOMP endpoints registered.");
    }
    @Override
    public void configureMessageBroker (MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/topic");
        log.info("Broker has been enabled.");
        registry.setApplicationDestinationPrefixes("/app");
        log.info("Application destination has been set.");
    }

}