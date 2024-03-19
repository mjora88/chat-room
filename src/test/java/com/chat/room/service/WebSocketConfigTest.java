package com.chat.room.service;

import com.chat.room.entity.Message;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class WebSocketConfigTest {
    @InjectMocks
    private WebSocketConfig webSocketConfig;

    @Mock
    private StompEndpointRegistry registry;

    private MockMvc mockMvc;
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(webSocketConfig).build();
    }

    @Test
    @Disabled // TODO trying to figure out how to test STOMPEndpoints
    public void testRegisterStompEndpoints() {
        webSocketConfig.registerStompEndpoints(registry);

        verify(registry, times(1)).addEndpoint("/websocket").withSockJS();
        assertNotNull(registry);

    }

    @Nested
    class ChatControllerTest {

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
}
