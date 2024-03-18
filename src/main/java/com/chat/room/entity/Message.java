package com.chat.room.entity;



import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.GenerationType;
import java.time.LocalDateTime;

@Entity
@Data
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sender;
    private String content;
    private LocalDateTime timestamp;
    @ManyToOne
    @JoinColumn(name ="chat_room_id")
    private ChatRoom chatRoom;

    public Message(long id, String sender, String content) {
        this.id = id;
        this.sender = sender;
        this.content = content;
    }
}
