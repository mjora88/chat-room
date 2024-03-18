package com.chat.room.service;

import com.chat.room.entity.Message;
import com.chat.room.repository.MessageRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

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

    @Test
    public void testGetAllMessages() {
        List<Message> messages = new ArrayList<>();
        Message message = new Message();
        message.setId(1L);
        message.setContent("Content1");
        message.setSender("Sender1");

        messages.add(message);
        message = new Message();
        message.setId(2L);
        message.setSender("Sender2");
        message.setContent("Content2");
        messages.add(message);

        when(messageRepository.findAll()).thenReturn(messages);

        List<Message> retrievedMessages = messageService.getAllMessages();

        assertThat(retrievedMessages).isNotEmpty();
        assertThat(retrievedMessages.size()).isEqualTo(2);

        verify(messageRepository, times(1)).findAll();
    }

    @Test
    public void testDeleteMessage () {

        doNothing().when(messageRepository).deleteById(1L);
        messageService.deleteMessage(1L);
        verify(messageRepository, times(1)).deleteById(1L);
    }
}
