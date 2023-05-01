package com.example.chatAPI.models;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "messages")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Chat chat;
    @ManyToOne
    private User author;
    private String text;
    private LocalDateTime createdAt = LocalDateTime.now();


}
