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
        Message message = new Message(1L, "Joe", "Content");

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
        messages.add(new Message(1L, "Sender1", "Content1"));
        messages.add(new Message(1L, "Sender2", "Content2"));

        when(messageRepository.findAll()).thenReturn(messages);

        List<Message> retrievedMessages = messageService.getAllMessages();

        assertThat(retrievedMessages).isNotEmpty();
        assertThat(retrievedMessages.size()).isEqualTo(2);

        verify(messageRepository, times(1)).findAll();
    }
}
