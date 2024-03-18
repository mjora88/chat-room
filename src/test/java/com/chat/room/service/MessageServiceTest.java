package com.chat.room.service;

import com.chat.room.entity.Message;
import com.chat.room.repository.MessageRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class MessageServiceTest {

    @Mock
    private MessageRepository messageRepository;

    @InjectMocks
    private MessageService messageService;

    @BeforeEach
    public void setUp () {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSaveMessage() {
        Message message = new Message();
        message.setId(1L);
        message.setSender("Joe");
        message.setContent("Content");

        when(messageRepository.save(any(Message.class))).thenReturn(message);

        Message savedMessage = messageService.saveMessage(message);

        assertThat(savedMessage.getId()).isEqualTo(1L);
        assertThat(savedMessage.getSender()).isEqualTo("Joe");
        assertThat(savedMessage.getContent()).isEqualTo("Content");

        verify(messageRepository, times(1)).save(any(Message.class));

    }


}
