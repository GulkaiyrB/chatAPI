package com.example.chatAPI.services;

import com.example.chatAPI.models.Chat;
import com.example.chatAPI.models.User;
import com.example.chatAPI.repository.ChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;


@Service
public class ChatService {
    private final ChatRepository chatRepository;
    private UserService userService;

    @Autowired
    public ChatService(ChatRepository chatRepository, UserService userService) {
        this.chatRepository = chatRepository;
        this.userService = userService;
    }

    public Long create(Chat chat) {
        chat.setCreatedAt(LocalDateTime.now());
        return chatRepository.save(chat).getId();
    }

    public List<Chat> getAllChats() {
        return chatRepository.findAll();
    }

    public Long deleteChat(Long id) {
        chatRepository.deleteById(id);
        return id;
    }

    public List<Chat> getChatsByUserId(Long userId) {
        User user = userService.getUserById(userId);
        if (user == null) {
            return Collections.emptyList();
        }
        return chatRepository.findByUsers(user);
    }



    public Chat getChatById(Long chatId) {
        Optional<Chat> chat = chatRepository.findById(chatId);
        if (chat.isEmpty()) {
            // обработка случая, когда чат не найден
            System.out.println("Чат с id " + chatId + " не найден");
        }
        return chat.get();
    }


}
